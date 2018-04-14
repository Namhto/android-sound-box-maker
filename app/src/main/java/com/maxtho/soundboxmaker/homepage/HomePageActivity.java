package com.maxtho.soundboxmaker.homepage;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxtho.soundboxmaker.homepage.boardtab.DashBoardFragment;
import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.homepage.markettab.MarketFragment;
import com.maxtho.soundboxmaker.homepage.soundtab.SoundFragment;

public class HomePageActivity extends AppCompatActivity implements
        SoundFragment.OnFragmentInteractionListener,
        MarketFragment.OnFragmentInteractionListener,
        DashBoardFragment.OnFragmentInteractionListener {

    private DashBoardFragment dashBoardFragment = new DashBoardFragment();

    private SoundFragment soundFragment = new SoundFragment();

    private MarketFragment marketFragment = new MarketFragment();

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_market:
                    getSupportFragmentManager().beginTransaction().replace(R.id.homepage_content, marketFragment).commit();
                    return true;
                case R.id.navigation_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.homepage_content, dashBoardFragment).commit();
                    return true;
                case R.id.navigation_sound:
                    getSupportFragmentManager().beginTransaction().replace(R.id.homepage_content, soundFragment).commit();
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        BottomNavigationView navigation = findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        //TODO
    }
}
