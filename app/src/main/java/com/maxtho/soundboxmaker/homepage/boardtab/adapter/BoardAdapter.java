package com.maxtho.soundboxmaker.homepage.boardtab.adapter;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.model.entity.Board;

import java.util.List;

/**
 * Created by Othman on 15/04/2018.
 */
public class BoardAdapter extends ArrayAdapter<Board> {

    private class BoardViewHolder {

        TextView title;

        TextView count;

        ImageView isFavorite;
    }

    public BoardAdapter(@NonNull Context context, int resource, @NonNull List<Board> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.board_list_item, parent, false);
        }
        BoardViewHolder viewHolder = (BoardViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new BoardViewHolder();
            viewHolder.title = convertView.findViewById(R.id.board_title);
            viewHolder.count = convertView.findViewById(R.id.board_count);
            viewHolder.isFavorite = convertView.findViewById(R.id.board_favorite);
            convertView.setTag(viewHolder);
        }

        Board item = getItem(position);
        viewHolder.title.setText(item.getTitle());
        viewHolder.count.setText(String.valueOf(item.getCount()) + " sounds");
        viewHolder.isFavorite.setImageResource(item.isFavorite() ? R.drawable.ic_star_black_24dp : R.drawable.ic_star_border_black_24dp);
        ((CardView) convertView.findViewById(R.id.board_list_item_root)).setCardBackgroundColor(Color.parseColor(item.getColor()));

        return convertView;
    }
}
