package com.alorma.multialarm.bbdd.contracts;

import android.provider.BaseColumns;

/**
 * Created by alorma on 7/10/13.
 */
public class CategoryContract implements BaseColumns {

    public static final String TABLE = "CATEGORIES";

    public static final String NAME = "name";
    public static final String PARENT = "parent";
    public static final String COLOR = "color";

}
