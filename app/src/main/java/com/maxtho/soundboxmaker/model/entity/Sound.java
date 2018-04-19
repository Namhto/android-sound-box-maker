package com.maxtho.soundboxmaker.model.entity;

import java.util.List;

public class Sound {

    private String id;

    private String name;

    private boolean isDefault;

    private String soundReference;

    private List<String> labels;

    private int color;

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

    public String getId() {
        return id;
    }

    public Sound setId(String id) {
        this.id = id;
        return this;
    }

    public List<String> getLabels() {
        return labels;
    }

    public Sound setLabels(List<String> labels) {
        this.labels = labels;
        return this;
    }

    public int getColor() {
        return color;
    }

    public Sound setColor(int color) {
        this.color = color;
        return this;
    }
}
