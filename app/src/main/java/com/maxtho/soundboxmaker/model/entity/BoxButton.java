package com.maxtho.soundboxmaker.model.entity;

public class BoxButton {

    private String title;

    private int position;

    private String soundReference;

    public int getPosition() {
        return position;
    }

    public BoxButton setPosition(int position) {
        this.position = position;
        return this;
    }

    public String getSoundReference() {
        return soundReference;
    }

    public BoxButton setSoundReference(String soundReference) {
        this.soundReference = soundReference;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public BoxButton setTitle(String title) {
        this.title = title;
        return this;
    }
}
