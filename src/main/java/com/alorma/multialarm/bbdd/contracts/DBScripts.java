package com.alorma.multialarm.bbdd.contracts;

import com.alorma.utils.DbUtils;

/**
 * Created by alorma on 7/10/13.
 */
public class DBScripts {

    public static String alarmTable() {
        DbUtils dbUtils = new DbUtils(AlarmContract.TABLE);

        dbUtils.addParam(AlarmContract.NAME, "TEXT");
        dbUtils.addParam(AlarmContract.HOUR, "number");
        dbUtils.addParam(AlarmContract.MINUTE, "number");
        dbUtils.addParam(AlarmContract.ACTIVE, "TEXT");
        dbUtils.addParam(AlarmContract.SOUND, "TEXT");
        dbUtils.addParam(AlarmContract.REPEAT, "TEXT");
        dbUtils.addParam(AlarmContract.REPEAT_DAYS, "TEXT");
        dbUtils.addParam(AlarmContract.CATEGORY, "INTEGER");

        return dbUtils.toString();
    }

    public static String categoryTable() {
        DbUtils dbUtils = new DbUtils(CategoryContract.TABLE);

        dbUtils.addParam(CategoryContract.NAME, "TEXT");
        dbUtils.addParam(CategoryContract.PARENT, "number");
        dbUtils.addParam(CategoryContract.COLOR, "number");

        return dbUtils.toString();
    }

}
