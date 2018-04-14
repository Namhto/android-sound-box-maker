package com.maxtho.soundboxmaker.homepage.soundtab.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.model.entity.Sound;

import java.util.HashMap;
import java.util.List;

public class SoundCategorieExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private List<String> expandableListCategorie;
    private HashMap<String, List<Sound>> expandableListSounds;

    public SoundCategorieExpandableListAdapter(Context context, List<String> expandableListTitle,
                                       HashMap<String, List<Sound>> expandableListDetail) {
        this.context = context;
        this.expandableListCategorie = expandableListTitle;
        this.expandableListSounds = expandableListDetail;
    }

    @Override
    public Object getChild(int listPosition, int expandedListPosition) {
        return this.expandableListSounds.get(this.expandableListCategorie.get(listPosition))
                .get(expandedListPosition);
    }

    @Override
    public long getChildId(int listPosition, int expandedListPosition) {
        return expandedListPosition;
    }

    @Override
    public View getChildView(int listPosition, final int expandedListPosition,
                             boolean isLastChild, View convertView, ViewGroup parent) {
        final Sound expandedSound = (Sound) getChild(listPosition, expandedListPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item_sound, null);
        }
        TextView expandedListTextView = (TextView) convertView
                .findViewById(R.id.tv_sound_title);
        expandedListTextView.setText(expandedSound.getName());
        return convertView;
    }

    @Override
    public int getChildrenCount(int listPosition) {
        return this.expandableListSounds.get(this.expandableListCategorie.get(listPosition))
                .size();
    }

    @Override
    public Object getGroup(int listPosition) {
        return this.expandableListCategorie.get(listPosition);
    }

    @Override
    public int getGroupCount() {
        return this.expandableListCategorie.size();
    }

    @Override
    public long getGroupId(int listPosition) {
        return listPosition;
    }

    @Override
    public View getGroupView(int listPosition, boolean isExpanded,
                             View convertView, ViewGroup parent) {

        String listTitle = (String) getGroup(listPosition);
        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) this.context.
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.list_item_categorie, null);
        }
        TextView listTitleTextView = (TextView) convertView.findViewById(R.id.tv_sound_categorie);
        listTitleTextView.setTypeface(null, Typeface.BOLD);
        listTitleTextView.setText(listTitle);

        /*
        ImageView imageViewSoundCategorie = (ImageView) convertView.findViewById(R.id.imageView_soundCategorie);
        if (isExpanded) {
            imageViewSoundCategorie.setImageResource(R.drawable.ic_arrow_drop_up_black_24dp);
        } else {
            imageViewSoundCategorie.setImageResource(R.drawable.ic_arrow_drop_down_black_24dp);
        }
        */

        return convertView;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public boolean isChildSelectable(int listPosition, int expandedListPosition) {
        return true;
    }

}
