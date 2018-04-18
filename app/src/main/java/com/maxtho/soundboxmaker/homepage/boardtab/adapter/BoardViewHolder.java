package com.maxtho.soundboxmaker.homepage.boardtab.adapter;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.ads.AdView;
import com.maxtho.soundboxmaker.R;

import static com.maxtho.soundboxmaker.homepage.boardtab.adapter.BoardAdapter.AD_TYPE;
import static com.maxtho.soundboxmaker.homepage.boardtab.adapter.BoardAdapter.CONTENT_TYPE;

/**
 * Created by Othman on 16/04/2018.
 */

public class BoardViewHolder extends RecyclerView.ViewHolder {

    public TextView title;

    public TextView count;

    public ImageView image;

    public CardView root;

    public AdView ad;

    public BoardViewHolder(View itemView, int viewType) {
        super(itemView);
        if (viewType == AD_TYPE) {
            ad = itemView.findViewById(R.id.board_ad_view);
        } else if (viewType == CONTENT_TYPE) {
            title = itemView.findViewById(R.id.board_title);
            count = itemView.findViewById(R.id.board_count);
            image = itemView.findViewById(R.id.board_image);
            root = itemView.findViewById(R.id.board_list_item_root);
        }
    }
}
