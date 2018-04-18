package com.maxtho.soundboxmaker;

public class Injector {
    private static Injector ourInstance = new Injector();
    private SBMComponent appComponent;

    private Injector() {
    }

    public static Injector getInstance() {
        return ourInstance;
    }

    public SBMComponent getAppComponent() {
        return appComponent;
    }

    public void setAppComponent(SBMComponent appComponent) {
        this.appComponent = appComponent;
    }
}
