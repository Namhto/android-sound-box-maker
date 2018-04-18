package com.maxtho.soundboxmaker;

import com.maxtho.soundboxmaker.homepage.HomePageActivity;
import com.maxtho.soundboxmaker.splashscreen.SplashScreenActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = SBMModule.class)
public interface SBMComponent {

    void inject(SBMApplication application);

    void inject(SplashScreenActivity activity);

    void inject(HomePageActivity activity);

}
