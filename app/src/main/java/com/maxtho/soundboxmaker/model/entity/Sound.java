package com.maxtho.soundboxmaker.model.entity;

public class Sound {

    private String name;

    private boolean isDefault;

    private String soundReference;

    public String getName() {
        return name;
    }

    public Sound setName(String name) {
        this.name = name;
        return this;
    }

    public String getSoundReference() {
        return soundReference;
    }

    public Sound setSoundReference(String soundReference) {
        this.soundReference = soundReference;
        return this;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public Sound setDefault(boolean aDefault) {
        isDefault = aDefault;
        return this;
    }
}
