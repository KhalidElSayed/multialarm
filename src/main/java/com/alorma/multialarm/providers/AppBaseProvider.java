package com.alorma.multialarm.providers;

import android.database.sqlite.SQLiteDatabase;

import com.alorma.multialarm.bbdd.SqlHelper;
import com.alorma.multialarm.providers.base.DespicableContentProvider;

public class AppBaseProvider extends DespicableContentProvider {

    public static final String AUTHORITY = "com.alorma.multialarm";
    private SQLiteDatabase db;

    @Override
    public void recruitMinions() {
        addMinion(new AlarmsMinion());
        addMinion(new AlarmsMinionByCategory());
        addMinion(new CategoriesMinion());
        addMinion(new CategoryMinion());
    }

    @Override
    public String getAuthority() {
        return AUTHORITY;
    }

    @Override
    public SQLiteDatabase getDb() {
        if (db == null) {
            db = new SqlHelper(getContext()).getWritableDatabase();
        }
        return db;
    }

}
