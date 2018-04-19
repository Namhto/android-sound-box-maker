package com.maxtho.soundboxmaker.model.entity;

public class BoxButton {

    private int position;

    private String SoundReference;

    public int getPosition() {
        return position;
    }

    public BoxButton setPosition(int position) {
        this.position = position;
        return this;
    }

    public String getSoundReference() {
        return SoundReference;
    }

    public BoxButton setSoundReference(String soundReference) {
        SoundReference = soundReference;
        return this;
    }
}
