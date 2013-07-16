package com.alorma.multialarm.ui.fragment;

import android.app.Fragment;
import android.app.ListFragment;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.alorma.multialarm.R;
import com.alorma.multialarm.bbdd.contracts.CategoryContract;
import com.alorma.multialarm.providers.AppBaseProvider;
import com.alorma.multialarm.providers.CategoriesMinion;
import com.alorma.utils.LoaderId;
import com.alorma.utils.UriBuilder;

/**
 * Created by alorma on 7/10/13.
 */
public class CategoriesFragment extends Fragment implements LoaderManager.LoaderCallbacks<Cursor>, AdapterView.OnItemClickListener {

    private SimpleCursorAdapter adapter;
    private OnCategoriesListener onCategoriesListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.ly_category, null);
        return v;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String[] from = {CategoryContract.NAME};
        int[] to = {R.id.text1};
        adapter = new SimpleCursorAdapter(getActivity(), R.layout.simple_expandable_list_item_1, null, from, to, 0);

        ListView list = (ListView) getView().findViewById(R.id.list);
        list.setOnItemClickListener(this);

        list.setAdapter(adapter);

        getLoaderManager().initLoader(LoaderId.getId(), null, this);

    }

    @Override
    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        Uri uri = UriBuilder.providerUri(AppBaseProvider.AUTHORITY, CategoriesMinion.PATH);
        return new CursorLoader(getActivity(), uri, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> cursorLoader, Cursor c) {
        adapter.swapCursor(c);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> cursorLoader) {

    }

    public void setOnCategoriesListener(OnCategoriesListener onCategoriesListener) {
        this.onCategoriesListener = onCategoriesListener;
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long id) {
        if (onCategoriesListener != null) {
            onCategoriesListener.onCategorySelected(id);
        }
    }

    public interface OnCategoriesListener {
        void onCategorySelected(long id);
    }
}
