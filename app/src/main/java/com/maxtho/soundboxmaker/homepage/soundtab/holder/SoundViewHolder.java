package com.maxtho.soundboxmaker.homepage.soundtab.holder;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.model.entity.Sound;

public class SoundViewHolder extends RecyclerView.ViewHolder {

    private Context context;

    public CardView cardView;
    public TextView title;
    public LinearLayout labels;

    public SoundViewHolder(Context context, View itemView) {
        super(itemView);

        this.context = context;

        cardView = itemView.findViewById(R.id.soundCardView);
        title = itemView.findViewById(R.id.tv_sound_name);
        labels = itemView.findViewById(R.id.ll_labels);
    }

    public void bind(Sound sound) {

        labels.removeAllViews();

        title.setText(sound.getName());
        for (String label : sound.getLabels()) {

            TextView tv = new TextView(context);
            tv.setBackgroundResource(R.drawable.rounded_corner);
            tv.setText(label);

            LinearLayout.LayoutParams parameter = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            parameter.setMargins(2, 2, 2, 2); // left, top, right, bottom
            tv.setLayoutParams(parameter);

            labels.addView(tv);
        }
    }
}