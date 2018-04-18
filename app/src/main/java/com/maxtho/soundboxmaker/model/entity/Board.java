package com.maxtho.soundboxmaker.model.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Othman on 15/04/2018.
 */

public class Board {

    private String title;

    private List<Sound> sounds = new ArrayList<>();

    private int color;

    private int imageResId = -1;

    public String getTitle() {
        return title;
    }

    public Board setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<Sound> getSounds() {
        return sounds;
    }

    public Board setSounds(List<Sound> sounds) {
        this.sounds = sounds;
        return this;
    }

    public int getColor() {
        return color;
    }

    public Board setColor(int color) {
        this.color = color;
        return this;
    }

    public int getImageResId() {
        return imageResId;
    }

    public Board setImageResId(int imageResId) {
        this.imageResId = imageResId;
        return this;
    }
}
