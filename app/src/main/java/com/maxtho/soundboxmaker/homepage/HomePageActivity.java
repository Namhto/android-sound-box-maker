package com.maxtho.soundboxmaker.homepage;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.google.android.gms.ads.MobileAds;
import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.SBMApplication;
import com.maxtho.soundboxmaker.homepage.boxtab.BoxFragment;
import com.maxtho.soundboxmaker.homepage.markettab.MarketFragment;
import com.maxtho.soundboxmaker.homepage.soundtab.SoundFragment;
import com.maxtho.soundboxmaker.manager.SBMManager;

import javax.inject.Inject;

public class HomePageActivity extends AppCompatActivity implements
        SoundFragment.OnFragmentInteractionListener,
        MarketFragment.OnFragmentInteractionListener,
        BoxFragment.OnFragmentInteractionListener {

    @Inject
    public SBMManager sbmManager;

    private BoxFragment boxFragment = new BoxFragment();

    private SoundFragment soundFragment = new SoundFragment();

    private MarketFragment marketFragment = new MarketFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_soundbox:
                    getSupportFragmentManager().beginTransaction().replace(R.id.homepage_content, boxFragment).commit();
                    return true;
                case R.id.navigation_sound:
                    getSupportFragmentManager().beginTransaction().replace(R.id.homepage_content, soundFragment).commit();
                    return true;
                case R.id.navigation_market:
                    getSupportFragmentManager().beginTransaction().replace(R.id.homepage_content, marketFragment).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        ((SBMApplication) getApplication()).component().inject(this);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        navigation.setSelectedItemId(R.id.navigation_soundbox);
        getSupportFragmentManager().beginTransaction().replace(R.id.homepage_content, boxFragment).commit();

        MobileAds.initialize(this, "YOUR_ADMOB_APP_ID");
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //TODO
    }
}
