package com.maxtho.soundboxmaker.homepage.boardtab.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.google.android.gms.ads.AdRequest;
import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.model.entity.Board;

import java.util.List;

/**
 * Created by Othman on 15/04/2018.
 */
public class BoardAdapter extends RecyclerView.Adapter<BoardViewHolder> {

    private Context context;

    private List<Board> items;

    static final int AD_TYPE = 0;

    public static final int CONTENT_TYPE = 1;

    private int lastPosition = -1;

    public BoardAdapter(Context context, List<Board> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) == null) {
            return AD_TYPE;
        }
        return CONTENT_TYPE;
    }

    @Override
    public BoardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = null;
        if (viewType == AD_TYPE) {
            itemView = LayoutInflater.from(context).inflate(R.layout.board_list_ad, parent, false);
        } else if (viewType == CONTENT_TYPE) {
            itemView = LayoutInflater.from(context).inflate(R.layout.board_list_item, parent, false);
        }
        return new BoardViewHolder(itemView, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull final BoardViewHolder viewHolder, int position) {
        if (viewHolder.getItemViewType() == AD_TYPE) {
            AdRequest adRequest = new AdRequest.Builder().build();
            viewHolder.ad.loadAd(adRequest);
        } else if (viewHolder.getItemViewType() == CONTENT_TYPE) {
            final Board item = items.get(position);
            viewHolder.title.setText(item.getTitle());
            viewHolder.count.setText(String.valueOf(item.getSounds().size()) + " sounds");
            if (item.getImageResId() != -1) {
                Drawable drawable = context.getDrawable(item.getImageResId());
                viewHolder.image.setImageDrawable(drawable);
            }
            viewHolder.root.setCardBackgroundColor(ResourcesCompat.getColor(context.getResources(), item.getColor(), null));
        }
        //setAnimation(viewHolder.itemView, position);
    }

    private void setAnimation(View viewToAnimate, int position) {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition) {
            Animation animation = AnimationUtils.loadAnimation(context, R.anim.slide_in);
            animation.setStartOffset(300);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<Board> getItems() {
        return items;
    }
}
