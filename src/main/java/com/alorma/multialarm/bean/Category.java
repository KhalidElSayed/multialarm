package com.alorma.multialarm.bean;

/**
 * Created by alorma on 7/10/13.
 */
public class Category {

    private int superCategory;
    private String name;
    private int color;

    public int getSuperCategory() {
        return superCategory;
    }

    public void setSuperCategory(int superCategory) {
        this.superCategory = superCategory;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
