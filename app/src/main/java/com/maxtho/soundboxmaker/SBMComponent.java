package com.maxtho.soundboxmaker;

import com.maxtho.soundboxmaker.homepage.HomePageActivity;
import com.maxtho.soundboxmaker.splashscreen.SplashScreenActivity;

import dagger.Component;

@Component(modules = SBMModule.class)
public interface SBMComponent {

    void inject(SplashScreenActivity activity);

    void inject(HomePageActivity activity);

}
