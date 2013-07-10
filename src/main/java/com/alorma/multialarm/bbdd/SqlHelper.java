package com.alorma.multialarm.bbdd;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.alorma.multialarm.bbdd.contracts.DBScripts;

public class SqlHelper extends SQLiteOpenHelper {


    public static String name = "change.db";
    public static int version = 2;

	public SqlHelper(Context context) {
		super(context, name, null, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		onUpgrade(db, 0, 1);
		onUpgrade(db, 1, 2);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (oldVersion == 0 && newVersion == 1) {
            db.execSQL(DBScripts.alarmTable());
            db.execSQL(DBScripts.categoryTable());
		}
	}

}
