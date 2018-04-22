package com.maxtho.soundboxmaker.homepage.boxtab.activity;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

    @BindView(R.id.box_toolbar_edit)
    Toolbar boxToolBarEdit;

    @BindView(R.id.box_title_edit)
    EditText boxTitleEdit;

    @BindView(R.id.box_color_edit)
    SBMColorPicker boxColorEdit;

    @BindView(R.id.box_image_edit)
    ImageView boxImageEdit;

    @BindView(R.id.box_image_delete)
    ImageView boxImageDelete;

    private Box box;

    private int selectedColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = getLayoutInflater().inflate(R.layout.activity_box_edit, null);
        ButterKnife.bind(this, view);

        ((SBMApplication) getApplication()).component().inject(this);
        box = sbmManager.getBoxByTitle(getIntent().getStringExtra("boxTitle"));
        selectedColor = box.getColor();
        setTitle("Board Edition");
        setTheme(getThemeIdByColor(box.getColor()));
        setSupportActionBar(boxToolBarEdit);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(box.getColor())));

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
        boxColorEdit.setSelectedColor(selectedColor);
        boxColorEdit.addOnColorSelectedListener(new SBMColorPicker.OnColorSelectedListener() {
            @Override
            public void onColorSelected(int newColor) {
                selectedColor = newColor;
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
                return R.style.RED;
            case R.color.PINK:
                return R.style.PINK;
            case R.color.INDIGO:
                return R.style.INDIGO;
            case R.color.BLUE:
                return R.style.BLUE;
            case R.color.GREEN:
                return R.style.GREEN;
            case R.color.LIME:
                return R.style.LIME;
            case R.color.YELLOW:
                return R.style.YELLOW;
            case R.color.ORANGE:
                return R.style.ORANGE;
            case R.color.GREY:
                return R.style.GREY;
            case R.color.BLUE_GREY:
                return R.style.BLUE_GREY;
            default:
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
        getMenuInflater().inflate(R.menu.box_edition, menu);
        return true;
    }
}
