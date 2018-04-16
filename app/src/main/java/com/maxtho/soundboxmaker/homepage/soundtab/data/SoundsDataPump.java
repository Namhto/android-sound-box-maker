package com.maxtho.soundboxmaker.homepage.soundtab.data;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.model.entity.Sound;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SoundsDataPump {

    public static List<Sound> getData() {

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
