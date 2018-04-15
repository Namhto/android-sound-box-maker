package com.maxtho.soundboxmaker.homepage.soundtab.holder;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxtho.soundboxmaker.R;

public class CategorieViewHolder extends RecyclerView.ViewHolder {

    public CardView cardView;
    public ImageView image_dropdown;
    public TextView title;
    public TextView categorie_number;
    public LinearLayout layout_sounds;
    private Context context;

    public CategorieViewHolder(Context context, View itemView) {
        super(itemView);

        this.context = context;

        cardView = itemView.findViewById(R.id.categorieCardView);
        image_dropdown = itemView.findViewById(R.id.imageView_soundCategorie);
        image_dropdown.setBackgroundResource(R.drawable.ic_arrow_drop_up);
        title = itemView.findViewById(R.id.tv_sound_categorie);
        categorie_number = itemView.findViewById(R.id.tv_categorie_number);
        layout_sounds = itemView.findViewById(R.id.ll_sounds);
        layout_sounds.setVisibility(View.GONE);

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("hey", "card");
                if (layout_sounds.getVisibility() == View.GONE) {
                    layout_sounds.setVisibility(View.VISIBLE);
                    image_dropdown.setBackgroundResource(R.drawable.ic_arrow_drop_down);
                } else {
                    layout_sounds.setVisibility(View.GONE);
                    image_dropdown.setBackgroundResource(R.drawable.ic_arrow_drop_up);
                }
            }
        });
    }

}