package com.maxtho.soundboxmaker.homepage.boxtab.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.SBMApplication;
import com.maxtho.soundboxmaker.manager.SBMManager;
import com.maxtho.soundboxmaker.model.entity.Box;

import javax.inject.Inject;

public class BoxActivity extends AppCompatActivity {

    @Inject
    public SBMManager sbmManager;

    private Box box;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ((SBMApplication) getApplication()).component().inject(this);
        box = sbmManager.getBoxByTitle(getIntent().getStringExtra("boxTitle"));
        setTitle(box.getTitle());
        setTheme(getThemeIdByColor(box.getColor()));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(R.layout.activity_box);
    }

    private int getThemeIdByColor(int color) {
        switch (color) {
            case R.color.RED: return R.style.RED;
            case R.color.PINK: return R.style.PINK;
            case R.color.INDIGO: return R.style.INDIGO;
            case R.color.BLUE: return R.style.BLUE;
            case R.color.GREEN: return R.style.GREEN;
            case R.color.LIME: return R.style.LIME;
            case R.color.YELLOW: return R.style.YELLOW;
            case R.color.ORANGE: return R.style.ORANGE;
            case R.color.GREY: return R.style.GREY;
            case R.color.BLUE_GREY: return R.style.BLUE_GREY;
            default: return R.style.AppTheme;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                terminate();
                return true;
        }
        return false;
    }

    private void terminate() {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    @Override
    public void onBackPressed() {
        terminate();
    }
}
