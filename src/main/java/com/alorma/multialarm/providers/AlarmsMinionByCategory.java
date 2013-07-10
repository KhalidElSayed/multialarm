package com.alorma.multialarm.providers;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.alorma.multialarm.bbdd.contracts.AlarmContract;

/**
 * Created by alorma on 7/10/13.
 */
public class AlarmsMinionByCategory extends AlarmsMinion {

    public static final String PATH = "alarms/category/#";

    @Override
    public String getBasePath() {
        return PATH;
    }

    @Override
    public Cursor query(SQLiteDatabase db, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return db.query(AlarmContract.TABLE, null, AlarmContract.CATEGORY + "= " + uri.getLastPathSegment(), selectionArgs, null, null, sortOrder);
    }

}
