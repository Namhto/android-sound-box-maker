package com.maxtho.soundboxmaker;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.maxtho.soundboxmaker.manager.SBMManager;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class SBMModule {

    private final SBMApplication application;

    public SBMModule(SBMApplication sbmApplication) {
        this.application = sbmApplication;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return application;
    }

    @Provides
    public Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    @Named("userdata")
    public SharedPreferences provideUserDataSharedPreferences(Context context) {
        return context.getSharedPreferences("userdata", Context.MODE_PRIVATE);
    }

    @Provides
    public SBMManager providesSoundBoxManager(@Named("userdata") SharedPreferences sharedPreferences, Gson gson) {
        return new SBMManager(sharedPreferences, gson);
    }

}
