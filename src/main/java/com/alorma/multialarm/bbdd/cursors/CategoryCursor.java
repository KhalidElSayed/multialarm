package com.alorma.multialarm.bbdd.cursors;

import android.content.ContentValues;
import android.database.Cursor;

import com.alorma.multialarm.bbdd.contracts.CategoryContract;
import com.alorma.multialarm.bean.Category;
import com.alorma.utils.BaseCursor;
import com.alorma.utils.CursorUtils;

/**
 * Created by alorma on 7/10/13.
 */
public class CategoryCursor extends BaseCursor<Category> {

    @Override
    public ContentValues write(Category category) {
        ContentValues values = new ContentValues();

        values.put(CategoryContract.NAME, category.getName());
        values.put(CategoryContract.COLOR, category.getColor());
        values.put(CategoryContract.PARENT, category.getSuperCategory());

        return values;
    }

    @Override
    public Category read(Cursor cursor) {
        Category category = new Category();
        CursorUtils cu = new CursorUtils(cursor);
        category.setName(cu.getString(CategoryContract.NAME));
        category.setColor(cu.getInt(CategoryContract.COLOR));
        category.setSuperCategory(cu.getInt(CategoryContract.PARENT));
        return category;
    }
}
