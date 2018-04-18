package com.maxtho.soundboxmaker;

import com.maxtho.soundboxmaker.manager.SBMManager;

import dagger.Module;
import dagger.Provides;

@Module
public class SBMModule {

    @Provides
    SBMManager providesSoundBoxManager() {
        return new SBMManager();
    }

}
