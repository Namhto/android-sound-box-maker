package com.maxtho.soundboxmaker.homepage.soundtab.adapter;

import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.homepage.soundtab.holder.SoundViewHolder;
import com.maxtho.soundboxmaker.model.entity.Sound;

import java.util.List;

public class SoundAdapter extends RecyclerView.Adapter<SoundViewHolder> {

    private Context context;

    private List<Sound> soundList;

    private MediaPlayer mp;

    public SoundAdapter(Context c, List<Sound> categorieList) {
        this.soundList = categorieList;
        this.context = c;
    }

    @NonNull
    @Override
    public SoundViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sound_list_item, parent, false);
        return new SoundViewHolder(parent.getContext(), view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoundViewHolder holder, int position) {
        final Sound sound = soundList.get(position);
        holder.bind(sound);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (mp != null) mp.stop();
                mp = MediaPlayer.create(view.getContext(), Integer.parseInt(sound.getSoundReference()));
                mp.start();
            }
        });
    }

    @Override
    public int getItemCount() {
        return soundList.size();
    }

    public SoundAdapter setSoundList(List<Sound> soundList) {
        this.soundList = soundList;
        notifyDataSetChanged();
        return this;
    }

}
