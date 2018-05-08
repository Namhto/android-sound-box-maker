package com.maxtho.soundboxmaker.model.entity;

import com.maxtho.soundboxmaker.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Othman on 15/04/2018.
 */

public class Box {

    private String title;

    private int position;

    private int color;

    private int imageResId = R.mipmap.board_default;

    private boolean isNative;

    private List<BoxButton> boxButtons = new ArrayList<>();
    private String id;

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

    public List<BoxButton> getBoxButtons() {
        return boxButtons;
    }

    public Box setBoxButtons(List<BoxButton> boxButtons) {
        this.boxButtons = boxButtons;
        return this;
    }

    public int getPosition() {
        return position;
    }

    public Box setPosition(int position) {
        this.position = position;
        return this;
    }

    public Box setId(String id) {
        this.id = id;
        return this;
    }

    public String getId() {
        return id;
    }
}
