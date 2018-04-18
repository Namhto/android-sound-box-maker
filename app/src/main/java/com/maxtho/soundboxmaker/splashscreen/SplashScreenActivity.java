package com.maxtho.soundboxmaker.splashscreen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.maxtho.soundboxmaker.SBMApplication;
import com.maxtho.soundboxmaker.homepage.HomePageActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((SBMApplication) getApplication()).component().inject(this);


        //TODO Remove Handler for prod app
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                startActivity(new Intent(SplashScreenActivity.this, HomePageActivity.class));
                finish();
            }
        }, 1000);


    }
}
