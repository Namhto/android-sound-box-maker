package com.maxtho.soundboxmaker.homepage.boxtab.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxtho.soundboxmaker.R;

/**
 * Created by Othman on 28/04/2018.
 */

public class BoxButtonViewHolder extends RecyclerView.ViewHolder {

    public CardView root;

    public TextView title;

    public ImageView image;

    public BoxButtonViewHolder(View itemView) {
        super(itemView);
        root = itemView.findViewById(R.id.button_list_item_root);
        title = itemView.findViewById(R.id.button_list_item_title);
        image = itemView.findViewById(R.id.button_list_item_image);
    }
}
