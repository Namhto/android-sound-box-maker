package com.maxtho.soundboxmaker.homepage.soundtab.data;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.model.entity.Sound;
import com.maxtho.soundboxmaker.model.entity.SoundCategorie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SoundsDataPump {

    public static HashMap<String, List<Sound>> getData() {
        HashMap<String, List<Sound>> expandableListDetail = new HashMap<String, List<Sound>>();

        Sound s1 = new Sound().setName("TVPALC").setSoundReference(R.raw.poulepondeuse);
        Sound s2 = new Sound().setName("Pssss").setSoundReference(R.raw.quarantecinq);
        Sound s3 = new Sound().setName("um um").setSoundReference(R.raw.poulepondeuse);
        Sound s4 = new Sound().setName("Ui").setSoundReference(R.raw.quarantecinq);
        Sound s5 = new Sound().setName("a").setSoundReference(R.raw.quarantecinq);
        Sound s6 = new Sound().setName("b").setSoundReference(R.raw.poulepondeuse);
        Sound s7 = new Sound().setName("c").setSoundReference(R.raw.quarantecinq);
        Sound s8 = new Sound().setName("d").setSoundReference(R.raw.poulepondeuse);
        Sound s9 = new Sound().setName("e").setSoundReference(R.raw.quarantecinq);
        Sound s10 = new Sound().setName("f").setSoundReference(R.raw.poulepondeuse);

        expandableListDetail.put("DxP", Arrays.asList(s1, s2, s3, s4));
        expandableListDetail.put("Repliques", Arrays.asList(s5, s6, s7, s8, s9, s10));
        expandableListDetail.put("Insultes", Arrays.asList(s1, s2, s3, s4));
        return expandableListDetail;
    }
}
