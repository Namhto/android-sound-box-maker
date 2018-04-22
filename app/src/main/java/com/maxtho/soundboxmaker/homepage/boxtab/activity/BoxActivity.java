package com.maxtho.soundboxmaker.homepage.boxtab.activity;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.SBMApplication;
import com.maxtho.soundboxmaker.manager.SBMManager;
import com.maxtho.soundboxmaker.model.entity.Box;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BoxActivity extends AppCompatActivity {

    @Inject
    public SBMManager sbmManager;

    private Box box;

    @BindView(R.id.box_toolbar_image)
    public ImageView boxToolBarImage;

    @BindView(R.id.box_toolbar_container)
    public CollapsingToolbarLayout boxToolBarContainer;

    @BindView(R.id.box_fab_button_add)
    public FloatingActionButton boxFabButtonAdd;

    @BindView(R.id.box_anim_toolbar)
    public Toolbar boxAnimToolBar;

    @BindView(R.id.box_app_bar)
    public AppBarLayout boxAppBar;

    private MenuItem addButtonMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = getLayoutInflater().inflate(R.layout.activity_box, null);
        ButterKnife.bind(this, view);

        ((SBMApplication) getApplication()).component().inject(this);
        box = sbmManager.getBoxByTitle(getIntent().getStringExtra("boxTitle"));

        setTheme(getThemeIdByColor(box.getColor()));
        setContentView(view);

        configureToolBar();
        configureCollapsingToolBarLayout();
        configureToolBarImage();
        configureFab();

        boxAppBar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                invalidateOptionsMenu();
            }
        });
    }

    private void configureToolBar() {
        setSupportActionBar(boxAnimToolBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void configureCollapsingToolBarLayout() {
        boxToolBarContainer.setTitle(box.getTitle());
        boxToolBarContainer.setContentScrimColor(getResources().getColor(box.getColor()));
    }

    private void configureToolBarImage() {
        boxToolBarImage.setImageDrawable(getDrawable(box.getImageResId()));
    }

    private void configureFab() {
        if (box.isNative()) {
            boxFabButtonAdd.setVisibility(View.GONE);
        }
        else {
            boxFabButtonAdd.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(box.getColor())));
            boxFabButtonAdd.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    addButton();
                }
            });
        }
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
            case R.id.action_box_button_add:
                addButton();
                return true;
        }
        return false;
    }

    private void addButton() {
        //TODO
        Toast.makeText(this, "TODO", Toast.LENGTH_SHORT).show();
    }

    private void terminate() {
        supportFinishAfterTransition();
    }

    @Override
    public void onBackPressed() {
        terminate();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!box.isNative()) {
            getMenuInflater().inflate(R.menu.box_add_button, menu);
            addButtonMenuItem = menu.findItem(R.id.action_box_button_add);
        }
        return true;
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        if (!box.isNative()) {
            if (boxAppBar.getHeight() - boxAppBar.getBottom() == 0) {
                addButtonMenuItem.setVisible(false).setEnabled(false);
            } else {
                addButtonMenuItem.setVisible(true).setEnabled(true);
            }
        }
        return super.onPrepareOptionsMenu(menu);
    }
}
