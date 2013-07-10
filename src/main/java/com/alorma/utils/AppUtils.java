package com.alorma.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by alorma on 19/05/13.
 */
public class AppUtils {

    public static boolean checkFirstTime(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        boolean first = prefs.getBoolean("FIRST", true);
        if (first) {
            saveFirstTime(context);
        }

        return first;
    }

    public static void saveFirstTime(Context context) {
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(context);

        SharedPreferences.Editor editor = prefs.edit();
        editor.putBoolean("FIRST", false);
        editor.commit();
    }
}
