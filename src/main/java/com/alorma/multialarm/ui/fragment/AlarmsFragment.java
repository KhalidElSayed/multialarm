package com.alorma.multialarm.ui.fragment;

import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SimpleCursorAdapter;

import com.alorma.multialarm.R;
import com.alorma.multialarm.bbdd.contracts.AlarmContract;
import com.alorma.multialarm.bbdd.contracts.CategoryContract;
import com.alorma.multialarm.bbdd.cursors.CategoryCursor;
import com.alorma.multialarm.bean.Category;
import com.alorma.multialarm.providers.AlarmsMinion;
import com.alorma.multialarm.providers.AlarmsMinionByCategory;
import com.alorma.multialarm.providers.AppBaseProvider;
import com.alorma.multialarm.providers.CategoryMinion;
import com.alorma.multialarm.ui.adapters.AlarmsAdapter;
import com.alorma.utils.LoaderId;
import com.alorma.utils.UriBuilder;

/**
 * Created by alorma on 7/10/13.
 */
public class AlarmsFragment extends ListFragment implements LoaderManager.LoaderCallbacks<Cursor>, AlarmsAdapter.OnAlarmStateListener {

    private AlarmsAdapter adapter;

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments() != null) {
            boolean categories = getArguments().getLong(AlarmContract.CATEGORY, -1) != -1;
            adapter = new AlarmsAdapter(getActivity(), null, categories);
            adapter.setOnAlarmStateListener(this);

            setListAdapter(adapter);

            if (getArguments().getLong(AlarmContract.CATEGORY, -1) != -1) {
                getLoaderManager().initLoader(LoaderId.getId(), getArguments(), this);

                Uri uri = UriBuilder.providerUri(AppBaseProvider.AUTHORITY, CategoryMinion.PATH, getArguments().getLong(AlarmContract.CATEGORY));
                Cursor c = getActivity().getContentResolver().query(uri, null, null, null, null);

                CategoryCursor categoryCursor = new CategoryCursor();
                Category category = categoryCursor.read(c);

                getActivity().getActionBar().setTitle(category.getName());
            } else {
                getLoaderManager().initLoader(LoaderId.getId(), null, this);
                getActivity().getActionBar().setTitle("All");
            }
        }


    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        Uri uri = UriBuilder.providerUri(AppBaseProvider.AUTHORITY, AlarmsMinion.PATH);
        if (getArguments() != null && getArguments().getLong(AlarmContract.CATEGORY, -1) != -1) {
            uri = UriBuilder.providerUri(AppBaseProvider.AUTHORITY, AlarmsMinionByCategory.PATH, getArguments().getLong(AlarmContract.CATEGORY));
        }
        return new CursorLoader(getActivity(), uri, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor c) {
        adapter.swapCursor(c);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {
        adapter.swapCursor(null);
    }

    @Override
    public void onAlarmEnabled(long id) {

    }

    @Override
    public void onAlarmDisabled(long id) {

    }
}
