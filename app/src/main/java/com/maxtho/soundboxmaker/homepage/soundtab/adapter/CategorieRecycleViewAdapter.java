package com.maxtho.soundboxmaker.homepage.soundtab.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.homepage.soundtab.holder.CategorieViewHolder;
import com.maxtho.soundboxmaker.model.entity.Sound;
import com.maxtho.soundboxmaker.model.entity.SoundCategorie;

import java.util.List;

public class CategorieRecycleViewAdapter extends RecyclerView.Adapter<CategorieViewHolder> {

    private Context context;

    private List<SoundCategorie> categorieList;

    private MediaPlayer mp;

    public CategorieRecycleViewAdapter(Context c, List<SoundCategorie> categorieList) {
        this.categorieList = categorieList;
        this.context = c;
    }

    @NonNull
    @Override
    public CategorieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_item_categorie, parent, false);
        return new CategorieViewHolder(parent.getContext(), view);
    }

    @Override
    public void onBindViewHolder(@NonNull CategorieViewHolder holder, int position) {

        SoundCategorie categorie = categorieList.get(position);

        holder.title.setText(categorie.getTitle());
        holder.categorie_number.setText(categorie.getSoundList().size() + " titres");

        for (final Sound s : categorie.getSoundList()) {

            TextView tv = new TextView(context);
            tv.setText(s.getName());
            tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (mp != null) mp.stop();
                    mp = MediaPlayer.create(view.getContext(), Integer.parseInt(s.getSoundReference()));
                    mp.start();
                }
            });

            holder.layout_sounds.addView(tv);
        }

    }

    @Override
    public int getItemCount() {
        return categorieList.size();
    }

}
