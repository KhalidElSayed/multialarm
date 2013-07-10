package com.alorma.utils;

import android.content.ContentValues;
import android.database.Cursor;

import java.util.List;

/**
 * Created by alorma on 19/05/13.
 */
public abstract class BaseCursor<K> {

    public abstract ContentValues write(K k);

    public ContentValues[] write(List<K> ks) {
        ContentValues[] values = new ContentValues[ks.size()];

        for (int i = 0; i < ks.size(); i++) {
            values[i] = write(ks.get(i));
        }

        return values;
    }

    public abstract K read(Cursor cursor);

}
