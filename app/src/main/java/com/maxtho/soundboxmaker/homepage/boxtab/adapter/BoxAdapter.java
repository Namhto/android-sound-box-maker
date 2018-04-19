package com.maxtho.soundboxmaker.homepage.boxtab.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.model.entity.Box;

import java.util.List;

/**
 * Created by Othman on 15/04/2018.
 */
public class BoxAdapter extends RecyclerView.Adapter<BoxViewHolder> {

    private Context context;

    private List<Box> items;

    static final int AD_TYPE = 0;

    public static final int CONTENT_TYPE = 1;

    public BoxAdapter(Context context, List<Box> items) {
        this.context = context;
        this.items = items;
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position) == null) {
            return AD_TYPE;
        }
        return CONTENT_TYPE;
    }

    @Override
    public BoxViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = null;
        if (viewType == AD_TYPE) {
            itemView = LayoutInflater.from(context).inflate(R.layout.box_list_ad, parent, false);
        } else if (viewType == CONTENT_TYPE) {
            itemView = LayoutInflater.from(context).inflate(R.layout.box_list_item, parent, false);
        }
        return new BoxViewHolder(itemView, viewType);
    }

    @Override
    public void onBindViewHolder(@NonNull final BoxViewHolder viewHolder, int position) {
        if (viewHolder.getItemViewType() == AD_TYPE) {

        } else if (viewHolder.getItemViewType() == CONTENT_TYPE) {
            final Box item = items.get(position);
            viewHolder.title.setText(item.getTitle());
            viewHolder.count.setText(String.valueOf(item.getBoardButtons().size()) + " sounds");
            viewHolder.image.setImageDrawable(context.getDrawable(item.getImageResId()));
            viewHolder.root.setCardBackgroundColor(ResourcesCompat.getColor(context.getResources(), item.getColor(), null));
            if (item.isNative()) {
                viewHolder.editContainer.setVisibility(View.INVISIBLE);
            }
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<Box> getItems() {
        return items;
    }
}
