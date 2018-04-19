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
                /*
                if(mp != null)mp.stop();
                if (s.isDefault()) {
                    mp = MediaPlayer.create(context, Integer.parseInt(s.getSoundReference()));
                } else {
                    try {
                        mp.setDataSource(s.getSoundReference());
                        mp.prepare();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                mp.start();
                return false;
        */
            }
        });
    }

    @Override
    public int getItemCount() {
        return soundList.size();
    }

    public List<Sound> getItems() {
        return soundList;
    }

    public SoundAdapter setSoundList(List<Sound> soundList) {
        this.soundList = soundList;
        notifyDataSetChanged();
        return this;
    }

}
