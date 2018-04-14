package com.maxtho.soundboxmaker.model.entity;

import java.io.Serializable;
import java.util.List;

public class SoundCategorie implements Serializable {

    private String title;
    private List<Sound> soundList;

    public String getTitle() {
        return title;
    }

    public SoundCategorie setTitle(String title) {
        this.title = title;
        return this;
    }

    public List<Sound> getSoundList() {
        return soundList;
    }

    public SoundCategorie setSoundList(List<Sound> soundList) {
        this.soundList = soundList;
        return this;
    }

}
