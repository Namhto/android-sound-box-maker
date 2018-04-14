package com.maxtho.soundboxmaker.homepage.soundtab.holder;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.model.entity.SoundCategorie;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategorieSoundViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    @BindView(R.id.tv_sound_categorie)
    public TextView textView_categorie;
    @BindView(R.id.ll_sound_items)
    public LinearLayout linearLayout_soundItems;

    private MediaPlayer mp;

    private Context context;

    private List<SoundCategorie> soundCategorieList;

    public CategorieSoundViewHolder(View itemView, List<SoundCategorie> soundCategorieList) {
        super(itemView);

        ButterKnife.bind(this, itemView);

        this.soundCategorieList = soundCategorieList;
        context = itemView.getContext();
        linearLayout_soundItems.setVisibility(View.GONE);

        int intMaxNoOfChild = 0;
        for (int index = 0; index < this.soundCategorieList.size(); index++) {
            int intMaxSizeTemp = this.soundCategorieList.get(index).getSoundList().size();
            if (intMaxSizeTemp > intMaxNoOfChild) intMaxNoOfChild = intMaxSizeTemp;
        }
        for (int indexView = 0; indexView < intMaxNoOfChild; indexView++) {
            TextView textView = new TextView(context);
            textView.setId(indexView);
            textView.setPadding(75, 20, 0, 20);
            textView.setGravity(Gravity.LEFT);
            textView.setBackground(ContextCompat.getDrawable(context, R.drawable.bg_sub_module_text));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            textView.setOnClickListener(this);
            linearLayout_soundItems.addView(textView, layoutParams);
        }
        textView_categorie.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.tv_sound_categorie) {
            if (linearLayout_soundItems.getVisibility() == View.VISIBLE) {
                linearLayout_soundItems.setVisibility(View.GONE);
            } else {
                linearLayout_soundItems.setVisibility(View.VISIBLE);
            }
        } else {
            TextView textViewClicked = (TextView) view;
            Toast.makeText(context, "" + textViewClicked.getText().toString(), Toast.LENGTH_SHORT).show();
            if(mp != null)mp.stop();
            mp = MediaPlayer.create(view.getContext(), Integer.parseInt(view.getTag().toString()));
            mp.start();

        }
    }
}
