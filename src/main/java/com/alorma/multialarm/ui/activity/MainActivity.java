package com.alorma.multialarm.ui.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.BaseColumns;
import android.support.v4.widget.SlidingPaneLayout;
import android.util.Log;

import com.alorma.multialarm.R;
import com.alorma.multialarm.bbdd.contracts.AlarmContract;
import com.alorma.multialarm.bbdd.cursors.AlarmCursor;
import com.alorma.multialarm.bbdd.cursors.CategoryCursor;
import com.alorma.multialarm.bean.Alarm;
import com.alorma.multialarm.bean.Category;
import com.alorma.multialarm.providers.AlarmsMinion;
import com.alorma.multialarm.providers.AppBaseProvider;
import com.alorma.multialarm.providers.CategoriesMinion;
import com.alorma.multialarm.ui.fragment.AlarmsFragment;
import com.alorma.multialarm.ui.fragment.CategoriesFragment;
import com.alorma.utils.AppUtils;
import com.alorma.utils.UriBuilder;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity implements CategoriesFragment.OnCategoriesListener {

    private SlidingPaneLayout slidingLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // BugSenseHandler.initAndStartSession(this, "bc8e43c4");

        slidingLayout = (SlidingPaneLayout) findViewById(R.id.sliding_pane_layout);
        slidingLayout.setShadowResource(R.drawable.sliding_pane_shadow);

        if (AppUtils.checkFirstTime(this)) {
            dummyCategories();
            dummyAlarms();
            slidingLayout.openPane();
        }

        setSlidingPanel();
        setSlidingContent(-1);
    }


    private void setSlidingPanel() {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        CategoriesFragment categoriesFragment = new CategoriesFragment();
        categoriesFragment.setOnCategoriesListener(this);
        ft.replace(R.id.left_pane, categoriesFragment);
        ft.commit();
    }

    private void setSlidingContent(long categoryId) {
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        AlarmsFragment alarmsFragment = new AlarmsFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(AlarmContract.CATEGORY, categoryId);
        alarmsFragment.setArguments(bundle);
        ft.replace(R.id.content_pane, alarmsFragment);
        ft.commit();
    }

    private void dummyCategories() {
        List<Category> categories = new ArrayList<Category>();

        for (int i = 0; i < 5; i++) {
            Category category = new Category();
            category.setName("Category " + i);
            category.setColor(getResources().getColor(android.R.color.holo_blue_dark));

            categories.add(category);
        }

        CategoryCursor categoryCursor = new CategoryCursor();
        getContentResolver().bulkInsert(UriBuilder.providerUri(AppBaseProvider.AUTHORITY, CategoriesMinion.PATH), categoryCursor.write(categories));

    }

    public void dummyAlarms() {
        Uri uri = UriBuilder.providerUri(AppBaseProvider.AUTHORITY, CategoriesMinion.PATH);
        Cursor c = getContentResolver().query(uri, null, null, null, null);

        if (c != null) {
            if (c.moveToFirst()) {
                List<Alarm> alarms = new ArrayList<Alarm>();
                do {
                    long id = c.getLong(c.getColumnIndex(BaseColumns._ID));

                    for (int i = 0; i < 5; i++) {
                        Alarm alarm = new Alarm();
                        alarm.setName("Alarm " + i + "C " + id);
                        alarm.setCategory(id);
                        alarms.add(alarm);
                    }
                } while (c.moveToNext());
                getContentResolver().bulkInsert(UriBuilder.providerUri(AppBaseProvider.AUTHORITY, AlarmsMinion.PATH), new AlarmCursor().write(alarms));
            }
        }
    }

    @Override
    public void onCategorySelected(long id) {
        slidingLayout.closePane();
        setSlidingContent(id);
    }
}
