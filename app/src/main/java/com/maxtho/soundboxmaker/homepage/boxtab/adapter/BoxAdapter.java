package com.maxtho.soundboxmaker.homepage.boxtab.adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.homepage.boxtab.activity.BoxActivity;
import com.maxtho.soundboxmaker.homepage.boxtab.activity.BoxEditActivity;
import com.maxtho.soundboxmaker.model.entity.Box;

import java.util.List;

/**
 * Created by Othman on 15/04/2018.
 */
public class BoxAdapter extends RecyclerView.Adapter<BoxViewHolder> {

    private Activity context;

    private List<Box> items;

    static final int AD_TYPE = 0;

    public static final int CONTENT_TYPE = 1;

    public BoxAdapter(Activity context, List<Box> items) {
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
    @SuppressLint("RestrictedApi")
    public void onBindViewHolder(@NonNull final BoxViewHolder viewHolder, int position) {
        if (viewHolder.getItemViewType() == AD_TYPE) {
            //TODO
        } else if (viewHolder.getItemViewType() == CONTENT_TYPE) {
            final Box item = items.get(position);
            viewHolder.title.setText(item.getTitle());
            viewHolder.count.setText(String.valueOf(item.getBoardButtons().size()) + " sounds");
            viewHolder.image.setImageDrawable(context.getDrawable(item.getImageResId()));
            viewHolder.root.setCardBackgroundColor(ResourcesCompat.getColor(context.getResources(), item.getColor(), null));
            if (item.isNative()) {
                viewHolder.edit.setVisibility(View.INVISIBLE);
            } else {
                viewHolder.edit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        View layout = context.getLayoutInflater().inflate(R.layout.box_popup_menu, null);
                        final PopupWindow popupWindow = new PopupWindow(context);
                        popupWindow.setContentView(layout);
                        popupWindow.setWidth(LinearLayout.LayoutParams.WRAP_CONTENT);
                        popupWindow.setHeight(LinearLayout.LayoutParams.WRAP_CONTENT);
                        popupWindow.setFocusable(true);
                        popupWindow.setBackgroundDrawable(new ColorDrawable(context.getResources().getColor(android.R.color.white)));
                        popupWindow.setElevation(80);
                        popupWindow.setAnimationStyle(R.style.PopUpMenuAnimation);

                        int[] loc_int = new int[2];
                        v.getLocationOnScreen(loc_int);
                        int x = loc_int[0] + 20;
                        int y = loc_int[1] + 20;
                        popupWindow.showAtLocation(layout, Gravity.TOP | Gravity.START,  x, y);

                        layout.findViewById(R.id.board_edit_button).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                onMenuEditClick(item);
                                popupWindow.dismiss();
                            }
                        });

                        layout.findViewById(R.id.board_delete_button).setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                onMenuDeleteClick(item);
                                popupWindow.dismiss();
                            }
                        });
                    }
                });
            }
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, BoxActivity.class);
                    intent.putExtra("boxTitle", item.getTitle());
                    context.startActivity(intent);
                    context.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
                }
            });
        }
    }

    private void onMenuEditClick(Box box) {
        Intent intent = new Intent(context, BoxEditActivity.class);
        intent.putExtra("boxTitle", box.getTitle());
        context.startActivity(intent);
        context.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_right);
    }

    private void onMenuDeleteClick(Box box) {

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public List<Box> getItems() {
        return items;
    }
}
