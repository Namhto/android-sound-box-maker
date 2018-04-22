package com.maxtho.soundboxmaker.homepage.boxtab.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.SBMApplication;
import com.maxtho.soundboxmaker.manager.SBMManager;
import com.maxtho.soundboxmaker.model.entity.Box;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BoxEditActivity extends AppCompatActivity {

    @Inject
    public SBMManager sbmManager;

    @BindView(R.id.box_title_edit)
    EditText boxTitleEdit;

    @BindView(R.id.box_color_edit)
    SBMColorPicker boxColorEdit;

    @BindView(R.id.box_image_edit)
    ImageView boxImageEdit;

    @BindView(R.id.box_image_delete)
    ImageView boxImageDelete;

    private Box box;

    private int color;

    private boolean isThemeDark;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = getLayoutInflater().inflate(R.layout.activity_box_edit, null);
        ButterKnife.bind(this, view);

        ((SBMApplication) getApplication()).component().inject(this);
        box = sbmManager.getBoxByTitle(getIntent().getStringExtra("boxTitle"));
        color = box.getColor();
        setTitle("Board Edition");
        setTheme(getThemeIdByColor(box.getColor()));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setContentView(view);

        configureBoxTitleEdit();
        configureBoxColorEdit();
        configureBoxImageEdit();
        configureBoxImageDelete();
    }

    private void configureBoxTitleEdit() {
        boxTitleEdit.setText(box.getTitle());
    }

    private void configureBoxColorEdit() {
        boxColorEdit.setSelectedColor(color);
        boxColorEdit.addOnColorSelectedListener(new SBMColorPicker.OnColorSelectedListener() {
            @Override
            public void onColorSelected(int newColor) {
                color = newColor;
            }
        });
    }

    private void configureBoxImageEdit() {

    }

    private void configureBoxImageDelete() {

    }

    private int getThemeIdByColor(int color) {
        switch (color) {
            case R.color.RED:
                isThemeDark = true;
                return R.style.RED;
            case R.color.PINK:
                isThemeDark = true;
                return R.style.PINK;
            case R.color.INDIGO:
                isThemeDark = true;
                return R.style.INDIGO;
            case R.color.BLUE:
                isThemeDark = true;
                return R.style.BLUE;
            case R.color.GREEN:
                isThemeDark = true;
                return R.style.GREEN;
            case R.color.LIME:
                isThemeDark = false;
                return R.style.LIME;
            case R.color.YELLOW:
                isThemeDark = false;
                return R.style.YELLOW;
            case R.color.ORANGE:
                isThemeDark = true;
                return R.style.ORANGE;
            case R.color.GREY:
                isThemeDark = false;
                return R.style.GREY;
            case R.color.BLUE_GREY:
                isThemeDark = true;
                return R.style.BLUE_GREY;
            default:
                isThemeDark = true;
                return R.style.AppTheme;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                terminate();
                return true;
            case R.id.action_box_edition_save:
                saveChangesAndTerminate();
                return true;
        }
        return false;
    }

    private void saveChangesAndTerminate() {
        terminate();
    }

    private void terminate() {
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    @Override
    public void onBackPressed() {
        terminate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (isThemeDark) {
            getMenuInflater().inflate(R.menu.box_edition_white, menu);
        } else {
            getMenuInflater().inflate(R.menu.box_edition_black, menu);
        }
        return true;
    }
}
