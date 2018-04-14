package com.maxtho.soundboxmaker.homepage.soundtab.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.homepage.soundtab.holder.CategorieSoundViewHolder;
import com.maxtho.soundboxmaker.model.entity.Sound;
import com.maxtho.soundboxmaker.model.entity.SoundCategorie;


import java.util.List;

public class SoundCategorieAdapter extends RecyclerView.Adapter<CategorieSoundViewHolder> {

    private List<SoundCategorie> soundCategorieList;

    public SoundCategorieAdapter(List<SoundCategorie> soundCategorieArrayList) {
        this.soundCategorieList = soundCategorieArrayList;
    }

    @NonNull
    @Override
    public CategorieSoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_categorie_sound_listing, parent, false);
        return new CategorieSoundViewHolder(itemView, soundCategorieList);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorieSoundViewHolder holder, int position) {
        SoundCategorie dummyParentDataItem = soundCategorieList.get(position);
        holder.textView_categorie.setText(dummyParentDataItem.getTitle());

        int noOfChildTextViews = holder.linearLayout_soundItems.getChildCount();
        int noOfChild = dummyParentDataItem.getSoundList().size();
        if (noOfChild < noOfChildTextViews) {
            for (int index = noOfChild; index < noOfChildTextViews; index++) {
                TextView currentTextView = (TextView) holder.linearLayout_soundItems.getChildAt(index);
                currentTextView.setVisibility(View.GONE);
            }
        }
        for (int textViewIndex = 0; textViewIndex < noOfChild; textViewIndex++) {
            TextView currentTextView = (TextView) holder.linearLayout_soundItems.getChildAt(textViewIndex);
            Sound s = dummyParentDataItem.getSoundList().get(textViewIndex);
            currentTextView.setText(s.getName());
            currentTextView.setTag(s.getSoundReference());
        }
    }

    @Override
    public int getItemCount() {
        return soundCategorieList.size();
    }
}
