package com.alorma.multialarm.providers;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

import com.alorma.multialarm.bbdd.contracts.AlarmContract;
import com.alorma.multialarm.bbdd.contracts.CategoryContract;
import com.alorma.multialarm.providers.base.MinionContentProvider;

/**
 * Created by alorma on 7/10/13.
 */
public class CategoriesMinion implements MinionContentProvider {


    public static final String PATH = "categories/";

    @Override
    public String getBasePath() {
        return PATH;
    }

    @Override
    public Cursor query(SQLiteDatabase db, Uri uri, String[] projection, String selection, String[] selectionArgs, String sortOrder) {
        return db.query(CategoryContract.TABLE, null, selection, selectionArgs, null, null, sortOrder);
    }

    @Override
    public long insert(SQLiteDatabase db, Uri uri, ContentValues contentValues) {
        return db.insert(CategoryContract.TABLE, null, contentValues);
    }

    @Override
    public int delete(SQLiteDatabase db, Uri uri, String where, String[] selectionArgs) {
        return db.delete(CategoryContract.TABLE, where, selectionArgs);
    }

    @Override
    public int update(SQLiteDatabase db, Uri uri, ContentValues values, String where, String[] selectionArgs) {
        return db.update(CategoryContract.TABLE, values, where, selectionArgs);
    }

    @Override
    public String getType() {
        return ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + AppBaseProvider.AUTHORITY + ".categories";
    }
}
