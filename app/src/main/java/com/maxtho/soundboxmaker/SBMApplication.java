package com.maxtho.soundboxmaker;

import android.app.Application;

public class SBMApplication extends Application {

    protected SBMComponent sbmComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sbmComponent = DaggerSBMComponent.builder()
                .sBMModule(new SBMModule(this))
                .build();
        component().inject(this);

    }

    public SBMComponent component() {
        return sbmComponent;
    }

}
