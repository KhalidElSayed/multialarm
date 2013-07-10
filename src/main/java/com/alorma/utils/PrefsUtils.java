package com.alorma.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by alorma on 19/05/13.
 */
public class PrefsUtils {

    private static SharedPreferences getSharedPreferences(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void saveString(Context context, String key, String value) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putString(key, value);
        edit.commit();
    }
    public static void saveBoolean(Context context, String key, boolean value) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putBoolean(key, value);
        edit.commit();
    }

    public static void saveInt(Context context, String key, int value) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putInt(key, value);
        edit.commit();
    }

    public static void saveLong(Context context, String key, long value) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putLong(key, value);
        edit.commit();
    }

    public static void saveFloat(Context context, String key, float value) {
        SharedPreferences.Editor edit = getSharedPreferences(context).edit();
        edit.putFloat(key, value);
        edit.commit();
    }

    public static String getString(Context context, String key) {
        return getSharedPreferences(context).getString(key, "");
    }

    public static int getInt(Context context, String key) {
        return getSharedPreferences(context).getInt(key, -1);
    }

}
