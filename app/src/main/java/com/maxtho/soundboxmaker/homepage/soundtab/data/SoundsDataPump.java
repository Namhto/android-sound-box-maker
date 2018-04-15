package com.maxtho.soundboxmaker.homepage.soundtab.data;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.model.entity.Sound;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SoundsDataPump {

    public static HashMap<String, List<Sound>> getData() {
        HashMap<String, List<Sound>> expandableListDetail = new HashMap<String, List<Sound>>();

        Sound s1 = new Sound().setName("Poule")
                .setSoundReference("" + R.raw.poulepondeuse)
                .setDefault(true);
        Sound s2 = new Sound().setName("Gun")
                .setSoundReference("" + R.raw.quarantecinq)
                .setDefault(true);
        Sound s3 = new Sound().setName("Cri")
                .setSoundReference("" + R.raw.cri)
                .setDefault(true);
        Sound s4 = new Sound().setName("Hey Hofman")
                .setSoundReference("" + R.raw.hehofman)
                .setDefault(true);
        Sound s5 = new Sound().setName("Je vais vous...")
                .setSoundReference("" + R.raw.jvaisvousenculer)
                .setDefault(true);
        Sound s6 = new Sound().setName("La calotte")
                .setSoundReference("" + R.raw.lacalote)
                .setDefault(true);
        Sound s7 = new Sound().setName("Lopez de vos morts")
                .setSoundReference("" + R.raw.lopezdevosmorts)
                .setDefault(true);
        Sound s8 = new Sound().setName("Ta femme")
                .setSoundReference("" + R.raw.tafemme)
                .setDefault(true);
        Sound s9 = new Sound().setName("Viens la toi")
                .setSoundReference("" + R.raw.vienslatoi)
                .setDefault(true);
        Sound s10 = new Sound().setName("Viens on va en finir")
                .setSoundReference("" + R.raw.viensonvaenfinir)
                .setDefault(true);
        expandableListDetail.put("Animaux", Arrays.asList(s1));
        expandableListDetail.put("Armes", Arrays.asList(s2));
        expandableListDetail.put("Lopez", Arrays.asList(s3, s4, s5, s6, s7, s8, s9));
        return expandableListDetail;
    }
}
