package com.maxtho.soundboxmaker;

import android.app.Application;

public class SBMApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Injector.getInstance().setAppComponent(DaggerSBMComponent.create());
    }
}
