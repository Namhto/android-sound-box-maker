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

    private List<Box> boxList;
    private Map<String, Sound> soundMap;

    public SBMManager(SharedPreferences sharedPreferences, Gson gson) {
        this.sharedPreferences = sharedPreferences;
        this.gson = gson;
        load();
    }

    public void load() {
        //TODO remove this when model fix
        sharedPreferences.edit().clear().commit();
        if ((sharedPreferences.getString(KEY_SOUNDS, null) == null) ||
                (sharedPreferences.getString(KEY_BOXES, null) == null)) {
            initData();
        } else {
            loadDataFromSharedPreferences();
        }
    }

    public void save() {
        sharedPreferences.edit().putString(KEY_BOXES, gson.toJson(boxList)).commit();
        sharedPreferences.edit().putString(KEY_SOUNDS, gson.toJson(soundMap)).commit();
    }

    public List<Box> getBoxList() {
        return boxList;
    }

    public SBMManager setBoxList(List<Box> boxList) {
        this.boxList = boxList;
        return this;
    }

    public Map<String, Sound> getSoundMap() {
        return soundMap;
    }

    public SBMManager setSoundMap(Map<String, Sound> soundMap) {
        this.soundMap = soundMap;
        return this;
    }

    private void initData() {
        initializeSoundsAndBoxes();
        Log.d(TAG, "initData : boxList : " + boxList + ", soundMap : " + soundMap);

        sharedPreferences.edit().putString(KEY_BOXES, gson.toJson(boxList)).commit();
        sharedPreferences.edit().putString(KEY_SOUNDS, gson.toJson(soundMap)).commit();
    }

    private void loadDataFromSharedPreferences() {
        Type listBoxType = new TypeToken<ArrayList<Box>>() {
        }.getType();
        Type mapSoundType = new TypeToken<HashMap<String, Sound>>() {
        }.getType();
        boxList = new Gson().fromJson(sharedPreferences.getString(KEY_BOXES, gson.toJson(boxList)), listBoxType);
        soundMap = new Gson().fromJson(sharedPreferences.getString(KEY_SOUNDS, gson.toJson(soundMap)), mapSoundType);
        Log.d(TAG, "loadDataFromSharedPreferences : boxList : " + boxList + ", soundMap : " + soundMap);

    }

    private void initializeSoundsAndBoxes() {

        boxList = new ArrayList<>();
        soundMap = new HashMap<>();

        //BOITE A LOPEZ
        List<String> labels_lopez = Arrays.asList("lopez");

        Sound sLopez1 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Cri")
                .setSoundReference("" + R.raw.cri)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(labels_lopez);
        soundMap.put(sLopez1.getId(), sLopez1);

        Sound sLopez2 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Hey Hofman")
                .setSoundReference("" + R.raw.hehofman)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(labels_lopez);
        soundMap.put(sLopez2.getId(), sLopez2);

        Sound sLopez3 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Je vais vous...")
                .setSoundReference("" + R.raw.jvaisvousenculer)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(labels_lopez);
        soundMap.put(sLopez3.getId(), sLopez3);

        Sound sLopez4 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("La calotte")
                .setSoundReference("" + R.raw.lacalote)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(labels_lopez);
        soundMap.put(sLopez4.getId(), sLopez4);

        Sound sLopez5 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Lopez de vos morts")
                .setSoundReference("" + R.raw.lopezdevosmorts)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(labels_lopez);
        soundMap.put(sLopez5.getId(), sLopez5);

        Sound sLopez6 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Ta femme")
                .setSoundReference("" + R.raw.tafemme)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(labels_lopez);
        soundMap.put(sLopez6.getId(), sLopez6);

        Sound sLopez7 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Viens la toi")
                .setSoundReference("" + R.raw.vienslatoi)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(labels_lopez);
        soundMap.put(sLopez7.getId(), sLopez7);

        Sound sLopez8 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName("Viens on va en finir")
                .setSoundReference("" + R.raw.viensonvaenfinir)
                .setDefault(true)
                .setColor(R.color.INDIGO)
                .setLabels(labels_lopez);
        soundMap.put(sLopez8.getId(), sLopez8);

        List<BoxButton> soundBoxesLopezList = new ArrayList<>();
        soundBoxesLopezList.add(new BoxButton().setPosition(1).setSoundReference(sLopez1.getId()));
        soundBoxesLopezList.add(new BoxButton().setPosition(2).setSoundReference(sLopez2.getId()));
        soundBoxesLopezList.add(new BoxButton().setPosition(3).setSoundReference(sLopez3.getId()));
        soundBoxesLopezList.add(new BoxButton().setPosition(4).setSoundReference(sLopez4.getId()));
        soundBoxesLopezList.add(new BoxButton().setPosition(5).setSoundReference(sLopez5.getId()));
        soundBoxesLopezList.add(new BoxButton().setPosition(6).setSoundReference(sLopez6.getId()));
        soundBoxesLopezList.add(new BoxButton().setPosition(7).setSoundReference(sLopez7.getId()));
        soundBoxesLopezList.add(new BoxButton().setPosition(8).setSoundReference(sLopez8.getId()));

        boxList.add(new Box()
                .setTitle("Boite à Lopez")
                .setColor(R.color.INDIGO)
                .setImageResId(R.mipmap.lopez)
                .setNative(true)
                .setBoardButtons(soundBoxesLopezList));

        //ARMES
        List<String> labels_gun = Arrays.asList("arme", "gun");
        Sound sGun1 = new Sound()
                .setId(UUID.randomUUID().toString())
                .setName(".45")
                .setSoundReference("" + R.raw.quarantecinq)
                .setDefault(true)
                .setColor(R.color.GREEN)
                .setLabels(labels_gun);
        soundMap.put(sGun1.getId(), sGun1);
        List<BoxButton> soundBoxesGunList = new ArrayList<>();
        soundBoxesGunList.add(new BoxButton().setPosition(1).setSoundReference(sGun1.getId()));
        boxList.add(new Box()
                .setTitle("Armes")
                .setColor(R.color.GREEN)
                .setImageResId(R.mipmap.arme)
                .setNative(true)
                .setBoardButtons(soundBoxesGunList));

        //ANIMAUX
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

        List<BoxButton> soundBoxesAnimalList = new ArrayList<>();
        soundBoxesAnimalList.add(new BoxButton().setPosition(1).setSoundReference(sPoule.getId()));
        soundBoxesAnimalList.add(new BoxButton().setPosition(2).setSoundReference(sBonobo.getId()));
        soundBoxesAnimalList.add(new BoxButton().setPosition(3).setSoundReference(sBouc.getId()));
        soundBoxesAnimalList.add(new BoxButton().setPosition(4).setSoundReference(sChevre.getId()));
        soundBoxesAnimalList.add(new BoxButton().setPosition(5).setSoundReference(sChimpanze.getId()));
        soundBoxesAnimalList.add(new BoxButton().setPosition(6).setSoundReference(sCoq.getId()));
        soundBoxesAnimalList.add(new BoxButton().setPosition(7).setSoundReference(sCroco.getId()));
        soundBoxesAnimalList.add(new BoxButton().setPosition(8).setSoundReference(sLion.getId()));
        boxList.add(new Box()
                .setTitle("Animaux")
                .setColor(R.color.ORANGE)
                .setImageResId(R.mipmap.animaux)
                .setNative(true)
                .setBoardButtons(soundBoxesAnimalList));


        //TODO
        boxList.add(new Box()
                .setTitle("Politique")
                .setColor(R.color.RED)
                .setImageResId(R.mipmap.politique)
                .setNative(true));
        /*boxList.add(new Box()
                .setTitle("Insultes")
                .setColor(R.color.YELLOW)
                .setImageResId(R.mipmap.insulte)
                .setNative(true)
        );*/
        boxList.add(new Box()
                .setTitle("Ma boite à son")
                .setColor(R.color.BLUE_GREY)
                .setNative(false));
        boxList.add(new Box()
                .setTitle("Sound box de bogoss")
                .setColor(R.color.LIME)
                .setNative(false));
        boxList.add(new Box()
                .setTitle("Cake")
                .setColor(R.color.PINK)
                .setNative(false));

    }

    public Box getBoxByTitle(String title) {
        for (Box box : boxList) {
            if (box.getTitle().equals(title)) {
                return box;
            }
        }
        throw new SBMException(ExceptionCode.BOX_NOT_FOUND);
    }
}
