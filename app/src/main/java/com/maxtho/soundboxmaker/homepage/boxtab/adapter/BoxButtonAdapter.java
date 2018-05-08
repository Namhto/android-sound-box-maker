package com.maxtho.soundboxmaker.homepage.boxtab.adapter;

import android.content.res.ColorStateList;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.homepage.boxtab.activity.BoxActivity;
import com.maxtho.soundboxmaker.model.entity.BoxButton;
import com.maxtho.soundboxmaker.model.entity.Sound;

import java.util.List;

/**
 * Created by Othman on 28/04/2018.
 */

public class BoxButtonAdapter extends RecyclerView.Adapter<BoxButtonViewHolder> {

    private BoxActivity context;

    private List<BoxButton> items;

    private MediaPlayer player;

    public BoxButtonAdapter(BoxActivity context, List<BoxButton> items) {
        this.context = context;
        this.items = items;
        this.player = new MediaPlayer();
    }

    @NonNull
    @Override
    public BoxButtonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.button_list_item, parent, false);
        return new BoxButtonViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final BoxButtonViewHolder viewHolder, int position) {
        final BoxButton item = items.get(position);
        final Sound sound = context.getSbmManager().getSoundMap().get(item.getSoundReference());
        viewHolder.title.setText(sound.getName());
        ViewGroup.LayoutParams params = viewHolder.root.getLayoutParams();
        params.height = setItemHeight();
        viewHolder.root.setLayoutParams(params);
        viewHolder.root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                player.stop();
                player.release();
                player = MediaPlayer.create(context, Integer.parseInt(sound.getSoundReference()));
                player.start();
                viewHolder.image.animate().rotation(-45).setDuration(250).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        viewHolder.image.animate().rotation(45).setDuration(250).withEndAction(new Runnable() {
                            @Override
                            public void run() {
                                viewHolder.image.animate().rotation(10).setDuration(250).scaleX(1).scaleY(1).start();
                            }
                        }).start();
                    }
                }).scaleX(1.2f).scaleY(1.2f).start();
            }
        });
        viewHolder.image.setImageTintList(ColorStateList.valueOf(context.getResources().getColor(context.getBox().getColor())));
    }

    private int setItemHeight() {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpWidth / 2 - 16, context.getResources().getDisplayMetrics());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<BoxButton> getItems() {
        return items;
    }
}
