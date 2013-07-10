package com.alorma.multialarm.bbdd.contracts;

import android.provider.BaseColumns;

/**
 * Created by alorma on 7/10/13.
 */
public interface AlarmContract extends BaseColumns{

    public static final String TABLE = "ALARM";

    public static final String NAME = "name";
    public static final String HOUR = "hour";
    public static final String MINUTE = "minute";
    public static final String SECTION = "section";
    public static final String ACTIVE = "active";
    public static final String SOUND = "sound";
    public static final String DISABLER = "allow_disable";
    public static final String REPEAT = "repeat";
    public static final String REPEAT_DAYS = "repeat_days";
    public static final String CATEGORY = "CATEGORY";

}
