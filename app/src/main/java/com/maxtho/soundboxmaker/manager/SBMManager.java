package com.maxtho.soundboxmaker.manager;

import android.content.SharedPreferences;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.exception.ExceptionCode;
import com.maxtho.soundboxmaker.exception.SBMException;
import com.maxtho.soundboxmaker.model.entity.Box;
import com.maxtho.soundboxmaker.model.entity.BoxButton;
import com.maxtho.soundboxmaker.model.entity.Sound;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SBMManager {

    private final String KEY_BOXES = "boxes";
    private final String KEY_SOUNDS = "sounds";
    private String TAG = "SBMManager";
    private Gson gson;
    private SharedPreferences sharedPreferences;

    private HashMap<String, Sound> soundMap = new HashMap<>();
    private HashMap<String, Box> boxMap = new HashMap<>();

    public SBMManager(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
        load();
    }

    private void load() {
        if ((sharedPreferences.getString(KEY_SOUNDS, null) == null) || (sharedPreferences.getString(KEY_BOXES, null) == null)) {
            initData();
        } else {
            loadDataFromSharedPreferences();
        }
    }

    public void save() {
        sharedPreferences.edit().putString(KEY_BOXES, gson.toJson(boxMap)).apply();
        sharedPreferences.edit().putString(KEY_SOUNDS, gson.toJson(soundMap)).apply();
    }

    public Map<String, Box> getBoxMap() {
        return new HashMap<>(boxMap);
    }

    public Box getBoxById(String id) {
        Box box = boxMap.get(id);
        if (box == null) {
            throw new SBMException(ExceptionCode.BOX_NOT_FOUND);
        }
        return box;
    }

    public Map<String, Sound> getSoundMap() {
        return new HashMap<>(soundMap);
    }

    public Sound getSoundById(String id) {
        Sound sound = soundMap.get(id);
        if (sound == null) {
            throw new SBMException(ExceptionCode.SOUND_NOT_FOUND);
        }
        return sound;
    }

    private void initData() {
        initDefaultModel();
        Log.d(TAG, "initData : boxMap : " + boxMap + ", soundMap : " + soundMap);
        sharedPreferences.edit().putString(KEY_BOXES, gson.toJson(boxMap)).apply();
        sharedPreferences.edit().putString(KEY_SOUNDS, gson.toJson(soundMap)).apply();
    }

    private void loadDataFromSharedPreferences() {
        Type boxMapType = new TypeToken<HashMap<String, Box>>() {}.getType();
        Type soundMapType = new TypeToken<HashMap<String, Sound>>() {}.getType();
        boxMap = new Gson().fromJson(sharedPreferences.getString(KEY_BOXES, gson.toJson(boxMap)), boxMapType);
        soundMap = new Gson().fromJson(sharedPreferences.getString(KEY_SOUNDS, gson.toJson(soundMap)), soundMapType);
        Log.d(TAG, "loadDataFromSharedPreferences : boxMap : " + boxMap + ", soundMap : " + soundMap);
    }

    private void initDefaultModel() {
        boxLopez();
        boxArmes();
        boxAnimaux();
        boxPolitique();
        boxInsultes();
        boxTest1();
        boxTest2();
        boxTest3();
    }

    private void boxLopez() {
        List<String> lopezLabels = Collections.singletonList("lopez");

        Sound sLopez1 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Cri")
                .setSoundReference("" + R.raw.cri)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(lopezLabels);
        soundMap.put(sLopez1.getId(), sLopez1);

        Sound sLopez2 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Hey Hofman")
                .setSoundReference("" + R.raw.hehofman)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(lopezLabels);
        soundMap.put(sLopez2.getId(), sLopez2);

        Sound sLopez3 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Je vais vous...")
                .setSoundReference("" + R.raw.jvaisvousenculer)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(lopezLabels);
        soundMap.put(sLopez3.getId(), sLopez3);

        Sound sLopez4 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("La calotte")
                .setSoundReference("" + R.raw.lacalote)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(lopezLabels);
        soundMap.put(sLopez4.getId(), sLopez4);

        Sound sLopez5 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Lopez de vos morts")
                .setSoundReference("" + R.raw.lopezdevosmorts)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(lopezLabels);
        soundMap.put(sLopez5.getId(), sLopez5);

        Sound sLopez6 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Ta femme")
                .setSoundReference("" + R.raw.tafemme)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(lopezLabels);
        soundMap.put(sLopez6.getId(), sLopez6);

        Sound sLopez7 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Viens la toi")
                .setSoundReference("" + R.raw.vienslatoi)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(lopezLabels);
        soundMap.put(sLopez7.getId(), sLopez7);

        Sound sLopez8 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Viens on va en finir")
                .setSoundReference("" + R.raw.viensonvaenfinir)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(lopezLabels);
        soundMap.put(sLopez8.getId(), sLopez8);

        List<BoxButton> boxButtons = new ArrayList<>();
        boxButtons.add(new BoxButton().setPosition(1).setSoundReference(sLopez1.getId()));
        boxButtons.add(new BoxButton().setPosition(2).setSoundReference(sLopez2.getId()));
        boxButtons.add(new BoxButton().setPosition(3).setSoundReference(sLopez3.getId()));
        boxButtons.add(new BoxButton().setPosition(4).setSoundReference(sLopez4.getId()));
        boxButtons.add(new BoxButton().setPosition(5).setSoundReference(sLopez5.getId()));
        boxButtons.add(new BoxButton().setPosition(6).setSoundReference(sLopez6.getId()));
        boxButtons.add(new BoxButton().setPosition(7).setSoundReference(sLopez7.getId()));
        boxButtons.add(new BoxButton().setPosition(8).setSoundReference(sLopez8.getId()));

        Box box = new Box()
                .setId(UUID.randomUUID().toString())
                .setPosition(0)
                .setTitle("Boite à Lopez")
                .setColor(R.color.INDIGO)
                .setImageResId(R.mipmap.lopez)
                .setNative(true)
                .setBoxButtons(boxButtons);
        boxMap.put(box.getId(), box);
    }

    private void boxArmes() {
        List<String> labels_gun = Arrays.asList("arme", "gun");

        Sound sGun1 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName(".45")
                .setSoundReference("" + R.raw.quarantecinq)
                .setDefault(true)
                .setColor(R.color.GREEN)
                .setLabels(labels_gun);
        soundMap.put(sGun1.getId(), sGun1);

        List<BoxButton> boxButtons = new ArrayList<>();
        boxButtons.add(new BoxButton().setPosition(1).setSoundReference(sGun1.getId()));

        Box box = new Box()
                .setId(UUID.randomUUID().toString())
                .setPosition(1)
                .setTitle("Armes")
                .setColor(R.color.GREEN)
                .setImageResId(R.mipmap.arme)
                .setNative(true)
                .setBoxButtons(boxButtons);
        boxMap.put(box.getId(), box);
    }

    private void boxAnimaux() {
        List<String> labels_animal = Arrays.asList("animal", "pet");

        Sound sPoule = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Poule")
                .setSoundReference("" + R.raw.poulepondeuse)
                .setDefault(true)
                .setColor(R.color.ORANGE)
                .setLabels(labels_animal);
        soundMap.put(sPoule.getId(), sPoule);

        Sound sBonobo = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Bonobo")
                .setSoundReference("" + R.raw.bonobo)
                .setDefault(true)
                .setColor(R.color.ORANGE)
                .setLabels(labels_animal);
        soundMap.put(sBonobo.getId(), sBonobo);

        Sound sBouc = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Bouc")
                .setSoundReference("" + R.raw.bouc)
                .setDefault(true)
                .setColor(R.color.ORANGE)
                .setLabels(labels_animal);
        soundMap.put(sBouc.getId(), sBouc);

        Sound sChevre = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Chevre")
                .setSoundReference("" + R.raw.chevre)
                .setDefault(true)
                .setColor(R.color.ORANGE)
                .setLabels(labels_animal);
        soundMap.put(sChevre.getId(), sChevre);

        Sound sChimpanze = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Chimpanze")
                .setSoundReference("" + R.raw.chimpanze)
                .setDefault(true)
                .setColor(R.color.ORANGE)
                .setLabels(labels_animal);
        soundMap.put(sChimpanze.getId(), sChimpanze);

        Sound sCoq = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Coq")
                .setSoundReference("" + R.raw.coq)
                .setDefault(true)
                .setColor(R.color.ORANGE)
                .setLabels(labels_animal);
        soundMap.put(sCoq.getId(), sCoq);

        Sound sCroco = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Croco")
                .setSoundReference("" + R.raw.croco)
                .setDefault(true)
                .setColor(R.color.ORANGE)
                .setLabels(labels_animal);
        soundMap.put(sCroco.getId(), sCroco);

        Sound sLion = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Lion")
                .setSoundReference("" + R.raw.lion)
                .setDefault(true)
                .setColor(R.color.ORANGE)
                .setLabels(labels_animal);
        soundMap.put(sLion.getId(), sLion);

        List<BoxButton> boxButtons = new ArrayList<>();
        boxButtons.add(new BoxButton().setPosition(1).setSoundReference(sPoule.getId()));
        boxButtons.add(new BoxButton().setPosition(2).setSoundReference(sBonobo.getId()));
        boxButtons.add(new BoxButton().setPosition(3).setSoundReference(sBouc.getId()));
        boxButtons.add(new BoxButton().setPosition(4).setSoundReference(sChevre.getId()));
        boxButtons.add(new BoxButton().setPosition(5).setSoundReference(sChimpanze.getId()));
        boxButtons.add(new BoxButton().setPosition(6).setSoundReference(sCoq.getId()));
        boxButtons.add(new BoxButton().setPosition(7).setSoundReference(sCroco.getId()));
        boxButtons.add(new BoxButton().setPosition(8).setSoundReference(sLion.getId()));

        Box box = new Box()
                .setId(UUID.randomUUID().toString())
                .setPosition(2)
                .setTitle("Animaux")
                .setColor(R.color.ORANGE)
                .setImageResId(R.mipmap.animaux)
                .setNative(true)
                .setBoxButtons(boxButtons);
        boxMap.put(box.getId(), box);
    }

    private void boxPolitique() {
        //TODO
        Box box = new Box()
                .setId(UUID.randomUUID().toString())
                .setPosition(3)
                .setTitle("Politique")
                .setColor(R.color.RED)
                .setImageResId(R.mipmap.politique)
                .setNative(true);
        boxMap.put(box.getId(), box);
    }

    private void boxInsultes() {
        //TODO
        Box box = new Box()
                .setPosition(4)
                .setId(UUID.randomUUID().toString())
                .setTitle("Insultes")
                .setColor(R.color.YELLOW)
                .setImageResId(R.mipmap.insulte)
                .setNative(true);
        boxMap.put(box.getId(), box);
    }

    private void boxTest1() {
        //TODO
        Box box = new Box()
                .setPosition(5)
                .setId(UUID.randomUUID().toString())
                .setTitle("Ma boite à son")
                .setColor(R.color.BLUE_GREY)
                .setNative(false);
        boxMap.put(box.getId(), box);
    }

    private void boxTest2() {
        //TODO
        Box box = new Box()
                .setPosition(6)
                .setId(UUID.randomUUID().toString())
                .setTitle("Sound box de bogoss")
                .setColor(R.color.LIME)
                .setNative(false);
        boxMap.put(box.getId(), box);
    }

    private void boxTest3() {
        //TODO
        Box box = new Box()
                .setPosition(7)
                .setId(UUID.randomUUID().toString())
                .setTitle("Cake")
                .setColor(R.color.PINK)
                .setNative(false);
        boxMap.put(box.getId(), box);
    }
}
