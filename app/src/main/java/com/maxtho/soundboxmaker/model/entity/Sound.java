package com.maxtho.soundboxmaker.model.entity;

public class Sound {

    private String name;

    private int soundReference;

    public String getName() {
        return name;
    }

    public Sound setName(String name) {
        this.name = name;
        return this;
    }

    public int getSoundReference() {
        return soundReference;
    }

    public Sound setSoundReference(int soundReference) {
        this.soundReference = soundReference;
        return this;
    }
}
