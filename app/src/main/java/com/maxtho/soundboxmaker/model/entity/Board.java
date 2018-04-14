package com.maxtho.soundboxmaker.model.entity;

/**
 * Created by Othman on 15/04/2018.
 */

public class Board {

    private String title;

    private int count;

    private boolean favorite;

    private String color = Color.BLUE_GREY;

    public String getTitle() {
        return title;
    }

    public Board setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getCount() {
        return count;
    }

    public Board setCount(int count) {
        this.count = count;
        return this;
    }

    public boolean isFavorite() {
        return favorite;
    }

    public Board setFavorite(boolean favorite) {
        this.favorite = favorite;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Board setColor(String color) {
        this.color = color;
        return this;
    }
}
