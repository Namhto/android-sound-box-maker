package com.maxtho.soundboxmaker.homepage.soundtab.holder;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.model.entity.Sound;

public class SoundViewHolder extends RecyclerView.ViewHolder {

    private Context context;

    public CardView cardView;
    public TextView title;
    public TextView categorie_number;

    public SoundViewHolder(Context context, View itemView) {
        super(itemView);

        this.context = context;

        cardView = itemView.findViewById(R.id.soundCardView);
        title = itemView.findViewById(R.id.tv_sound_name);
        categorie_number = itemView.findViewById(R.id.tv_sound_label);

    }

    public void bind(Sound sound) {
        title.setText(sound.getName());
        categorie_number.setText(" titres");
    }
}