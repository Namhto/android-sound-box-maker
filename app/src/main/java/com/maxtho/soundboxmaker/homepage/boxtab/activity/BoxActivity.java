package com.maxtho.soundboxmaker.homepage.boxtab.activity;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.SBMApplication;
import com.maxtho.soundboxmaker.homepage.boxtab.adapter.BoxButtonAdapter;
import com.maxtho.soundboxmaker.manager.SBMManager;
import com.maxtho.soundboxmaker.model.entity.Box;
import com.maxtho.soundboxmaker.model.entity.BoxButton;

import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BoxActivity extends AppCompatActivity {

    @Inject
    public SBMManager sbmManager;

    private Box box;

    private BoxButtonAdapter adapter;

    @BindView(R.id.box_fab_button_add)
    public FloatingActionButton fab;

    @BindView(R.id.button_list)
    public RecyclerView buttonList;

    @BindView(R.id.button_list_item_delete)
    public ImageView buttonDelete;

    private boolean isDeleteRequested = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        View view = getLayoutInflater().inflate(R.layout.activity_box, null);
        ButterKnife.bind(this, view);

        ((SBMApplication) getApplication()).component().inject(this);
        box = sbmManager.getBoxById(getIntent().getStringExtra("boxId"));

        setTheme(getThemeIdByColor(box.getColor()));
        setTitle(box.getTitle());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        buttonDelete.setVisibility(View.INVISIBLE);

        setContentView(view);

        configureFab();
        populateBoardList(box.getBoxButtons());
        configureRecyclerViewBehavior();
    }

    private void populateBoardList(List<BoxButton> list) {
        adapter = new BoxButtonAdapter(this, list);
        buttonList.setLayoutManager(new GridLayoutManager(this, 2));
        buttonList.setAdapter(adapter);
    }

    private void configureRecyclerViewBehavior() {
        buttonList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    fab.clearAnimation();
                    fab.animate().translationY(fab.getHeight() * 2).setDuration(300);
                } else if (dy < 0) {
                    fab.clearAnimation();
                    fab.animate().translationY(0).setDuration(300);
                }
            }
        });
        ItemTouchHelper.Callback itemTouchHelperCallback = new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG, ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.START | ItemTouchHelper.END);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Collections.swap(adapter.getItems(), viewHolder.getAdapterPosition(), target.getAdapterPosition());
                adapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }

            @Override
            public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int actionState) {
                super.onSelectedChanged(viewHolder, actionState);
                if (actionState == ItemTouchHelper.ACTION_STATE_DRAG) {
                    viewHolder.itemView.animate().scaleX(1.05f).setDuration(250);
                    viewHolder.itemView.animate().scaleY(1.05f).setDuration(250);
                    buttonDelete.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void clearView(RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder) {
                super.clearView(recyclerView, viewHolder);
                if (isDeleteRequested) {
                    viewHolder.itemView.animate().scaleX(0).setDuration(250);
                    viewHolder.itemView.animate().scaleY(0).setDuration(250).withEndAction(new Runnable() {
                        @Override
                        public void run() {
                            adapter.getItems().remove(viewHolder.getAdapterPosition());
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
                else {
                    viewHolder.itemView.animate().scaleX(1).setDuration(250);
                    viewHolder.itemView.animate().scaleY(1).setDuration(250);
                }
                buttonDelete.setVisibility(View.INVISIBLE);
            }

            @Override
            public void onChildDraw(Canvas c, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float dX, float dY, int actionState, boolean isCurrentlyActive) {
                super.onChildDraw(c, recyclerView, viewHolder, dX, dY, actionState, isCurrentlyActive);
                if (viewHolder.itemView.getY() + viewHolder.itemView.getHeight() < buttonDelete.getBottom()) {
                    buttonDelete.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.RED_DARK)));
                    buttonDelete.setImageDrawable(getDrawable(R.drawable.ic_delete_open));
                    isDeleteRequested = true;
                }
                else {
                    buttonDelete.setImageTintList(ColorStateList.valueOf(getResources().getColor(R.color.black)));
                    buttonDelete.setImageDrawable(getDrawable(R.drawable.ic_delete));
                    if (isCurrentlyActive) {
                        isDeleteRequested = false;
                    }
                }
            }
        };

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(itemTouchHelperCallback);
        itemTouchHelper.attachToRecyclerView(buttonList);
    }

    private void configureFab() {
        if (box.isNative()) {
            fab.setVisibility(View.GONE);
        } else {
            fab.setBackgroundTintList(ColorStateList.valueOf(getResources().getColor(box.getColor())));
            fab.setOnClickListener(new View.OnClickListener() {
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
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
    }

    @Override
    public void onBackPressed() {
        terminate();
    }

    public Box getBox() {
        return box;
    }

    public SBMManager getSbmManager() {
        return sbmManager;
    }
}
