package com.alorma.multialarm.bbdd.cursors;

import android.content.ContentValues;
import android.database.Cursor;
import android.provider.BaseColumns;

import com.alorma.multialarm.bbdd.contracts.AlarmContract;
import com.alorma.multialarm.bean.Alarm;
import com.alorma.utils.BaseCursor;
import com.alorma.utils.CursorUtils;

/**
 * Created by alorma on 7/10/13.
 */
public class AlarmCursor extends BaseCursor<Alarm> {

    @Override
    public ContentValues write(Alarm alarm) {
        ContentValues values = new ContentValues();

        values.put(AlarmContract.NAME, alarm.getName());
        values.put(AlarmContract.CATEGORY, alarm.getCategory());
        values.put(AlarmContract.SOUND, alarm.getSoundUri());
        values.put(AlarmContract.ACTIVE, alarm.isActive());
        values.put(AlarmContract.HOUR, alarm.getHour());
        values.put(AlarmContract.MINUTE, alarm.getMinute());

        return values;
    }

    @Override
    public Alarm read(Cursor cursor) {
        Alarm alarm = new Alarm();

        CursorUtils cu = new CursorUtils(cursor);

        alarm.setName(cu.getLong(BaseColumns._ID) + " - " + cu.getString(AlarmContract.NAME));
        alarm.setActive(cu.getBoolean(AlarmContract.ACTIVE));
        alarm.setHour(cu.getInt(AlarmContract.HOUR));
        alarm.setMinute(cu.getInt(AlarmContract.MINUTE));
        alarm.setSound(cu.getString(AlarmContract.SOUND));

        return alarm;
    }
}
