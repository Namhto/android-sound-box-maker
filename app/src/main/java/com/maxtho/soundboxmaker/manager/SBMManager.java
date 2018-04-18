package com.maxtho.soundboxmaker.manager;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.model.entity.Box;
import com.maxtho.soundboxmaker.model.entity.Sound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SBMManager {

    private List<Box> boxList;

    private List<Sound> soundList;

    public SBMManager() {
        load();
    }

    public void load() {
        boxList = getBoxData();
        soundList = getSoundData();
    }

    public void save() {

    }

    public List<Box> getBoxList() {
        return boxList;
    }

    public SBMManager setBoxList(List<Box> boxList) {
        this.boxList = boxList;
        return this;
    }

    public List<Sound> getSoundList() {
        return soundList;
    }

    public SBMManager setSoundList(List<Sound> soundList) {
        this.soundList = soundList;
        return this;
    }

    private List<Box> getBoxData() {
        List<Box> list = new ArrayList<>();
        list.add(new Box().setTitle("Politique").setColor(R.color.RED).setImageResId(R.mipmap.politique).setNative(true));
        list.add(new Box().setTitle("Insultes").setColor(R.color.YELLOW).setImageResId(R.mipmap.insulte).setNative(true));
        list.add(new Box().setTitle("Boite à Lopez").setColor(R.color.INDIGO).setImageResId(R.mipmap.lopez).setNative(true));
        list.add(new Box().setTitle("Armes").setColor(R.color.GREEN).setImageResId(R.mipmap.arme).setNative(true));
        list.add(new Box().setTitle("Animaux").setColor(R.color.ORANGE).setImageResId(R.mipmap.animaux).setNative(true));
        list.add(new Box().setTitle("Ma boite à son").setColor(R.color.BLUE_GREY).setNative(false));
        list.add(new Box().setTitle("Sound box de bogoss").setColor(R.color.LIME).setNative(false));
        list.add(new Box().setTitle("Cake").setColor(R.color.PINK).setNative(false));
        return list;
    }

    private List<Sound> getSoundData() {

        List<String> labels_1 = Arrays.asList("rigolo", "fun", "animal");
        List<String> labels_2 = Arrays.asList("rigolo", "fun", "arme");
        List<String> labels_3 = Arrays.asList("fun", "lopez");
        List<String> labels_4 = Arrays.asList("fun", "lopez", "rigolo", "fun", "animal", "rigolo", "fun", "animal", "animal", "animal");

        Sound s1 = new Sound().setName("Poule")
                .setSoundReference("" + R.raw.poulepondeuse)
                .setDefault(true)
                .setLabels(labels_1);
        Sound s2 = new Sound().setName("Gun")
                .setSoundReference("" + R.raw.quarantecinq)
                .setDefault(true)
                .setLabels(labels_2);
        Sound s3 = new Sound().setName("Cri")
                .setSoundReference("" + R.raw.cri)
                .setDefault(true)
                .setLabels(labels_3);
        Sound s4 = new Sound().setName("Hey Hofman")
                .setSoundReference("" + R.raw.hehofman)
                .setDefault(true)
                .setLabels(labels_3);
        Sound s5 = new Sound().setName("Je vais vous...")
                .setSoundReference("" + R.raw.jvaisvousenculer)
                .setDefault(true)
                .setLabels(labels_3);
        Sound s6 = new Sound().setName("La calotte")
                .setSoundReference("" + R.raw.lacalote)
                .setDefault(true)
                .setLabels(labels_3);
        Sound s7 = new Sound().setName("Lopez de vos morts")
                .setSoundReference("" + R.raw.lopezdevosmorts)
                .setDefault(true)
                .setLabels(labels_3);
        Sound s8 = new Sound().setName("Ta femme")
                .setSoundReference("" + R.raw.tafemme)
                .setDefault(true)
                .setLabels(labels_3);
        Sound s9 = new Sound().setName("Viens la toi")
                .setSoundReference("" + R.raw.vienslatoi)
                .setDefault(true)
                .setLabels(labels_3);
        Sound s10 = new Sound().setName("Viens on va en finir")
                .setSoundReference("" + R.raw.viensonvaenfinir)
                .setDefault(true)
                .setLabels(labels_3);
        Sound s11 = new Sound().setName("NO label")
                .setSoundReference("" + R.raw.viensonvaenfinir)
                .setDefault(true)
                .setLabels(new ArrayList<String>());
        Sound s12 = new Sound().setName("NULL label")
                .setSoundReference("" + R.raw.viensonvaenfinir)
                .setDefault(true)
                .setLabels(new ArrayList<String>());
        Sound s13 = new Sound().setName("LOT OF label")
                .setSoundReference("" + R.raw.viensonvaenfinir)
                .setDefault(true)
                .setLabels(labels_4);

        return Arrays.asList(s1, s2, s3, s4, s5, s6, s7, s8, s9, s10, s11, s12, s13);
    }
}
