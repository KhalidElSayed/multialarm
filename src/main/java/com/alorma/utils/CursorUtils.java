package com.alorma.utils;

import android.database.Cursor;

/**
 * Created by alorma on 19/05/13.
 */
public class CursorUtils {

    private final Cursor cursor;

    public CursorUtils(Cursor cursor) {
        this.cursor = cursor;
        cursor.moveToFirst();
    }


    public String getString(String column) {
        return cursor.getString(cursor.getColumnIndex(column));
    }

    public int getInt(String column) {
        return cursor.getInt(cursor.getColumnIndex(column));
    }

    public long getLong(String column) {
        return cursor.getLong(cursor.getColumnIndex(column));
    }

    public boolean getBoolean(String column) {
        return cursor.getString(cursor.getColumnIndex(column)).equalsIgnoreCase("true");
    }

    public static String getString(Cursor c, String column) {
        return c.getString(c.getColumnIndex(column));
    }

    public static int getInt(Cursor c, String column) {
        return c.getInt(c.getColumnIndex(column));
    }

    public static long getLong(Cursor c, String column) {
        return c.getLong(c.getColumnIndex(column));
    }

    public static boolean getBoolean(Cursor c, String column) {
        return c.getString(c.getColumnIndex(column)).equalsIgnoreCase("true");
    }

}
