package com.alorma.multialarm.ui.activity;

import android.app.Activity;
import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.os.Bundle;
import android.support.v4.widget.SlidingPaneLayout;

import com.alorma.multialarm.R;
import com.alorma.multialarm.bbdd.contracts.AlarmContract;
import com.alorma.multialarm.bbdd.cursors.CategoryCursor;
import com.alorma.multialarm.bean.Category;
import com.alorma.multialarm.providers.AppBaseProvider;
import com.alorma.multialarm.providers.CategoriesMinion;
import com.alorma.multialarm.ui.fragment.AlarmsFragment;
import com.alorma.multialarm.ui.fragment.CategoriesFragment;
import com.alorma.utils.AppUtils;
import com.alorma.utils.UriBuilder;
import com.bugsense.trace.BugSenseHandler;

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

        if (AppUtils.checkFirstTime(this)) {
            dummyCategories();
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

    @Override
    public void onCategorySelected(long id) {
        slidingLayout.closePane();
        setSlidingContent(id);
    }
}
