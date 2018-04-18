package com.maxtho.soundboxmaker.model.entity;

import java.util.List;

public class BoxButton {

    private int position;

    private List<String> SoundReferences;

    public int getPosition() {
        return position;
    }

    public BoxButton setPosition(int position) {
        this.position = position;
        return this;
    }

    public List<String> getSoundReferences() {
        return SoundReferences;
    }

    public BoxButton setSoundReferences(List<String> soundReferences) {
        SoundReferences = soundReferences;
        return this;
    }
}
