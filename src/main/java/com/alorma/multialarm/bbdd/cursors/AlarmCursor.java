package com.alorma.multialarm.bbdd.cursors;

import android.content.ContentValues;
import android.database.Cursor;

import com.alorma.multialarm.bean.Alarm;
import com.alorma.utils.BaseCursor;

/**
 * Created by alorma on 7/10/13.
 */
public class AlarmCursor extends BaseCursor<Alarm> {

    @Override
    public ContentValues write(Alarm alarm) {
        return null;
    }

    @Override
    public Alarm read(Cursor cursor) {
        return null;
    }
}
