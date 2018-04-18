package com.maxtho.soundboxmaker.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Othman on 15/04/2018.
 */

public class Box {

    private String title;

    private int color;

    private int imageResId = -1;

    private boolean isNative;

    private List<BoxButton> boardButtons = new ArrayList<>();

    public String getTitle() {
        return title;
    }

    public Box setTitle(String title) {
        this.title = title;
        return this;
    }

    public int getColor() {
        return color;
    }

    public Box setColor(int color) {
        this.color = color;
        return this;
    }

    public int getImageResId() {
        return imageResId;
    }

    public Box setImageResId(int imageResId) {
        this.imageResId = imageResId;
        return this;
    }

    public boolean isNative() {
        return isNative;
    }

    public Box setNative(boolean aNative) {
        isNative = aNative;
        return this;
    }

    public List<BoxButton> getBoardButtons() {
        return boardButtons;
    }

    public Box setBoardButtons(List<BoxButton> boardButtons) {
        this.boardButtons = boardButtons;
        return this;
    }
}
