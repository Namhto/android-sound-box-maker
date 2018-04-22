package com.maxtho.soundboxmaker.homepage.boxtab.activity;

import android.content.Context;
import android.content.res.Resources;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.View;
import android.widget.LinearLayout;

import com.maxtho.soundboxmaker.R;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by Othman on 21/04/2018.
 */

public class SBMColorPicker extends LinearLayout {

    private List<Pair<CircleImageView, Integer>> colors = new ArrayList<>();

    private List<OnColorSelectedListener> listeners = new ArrayList<>();

    private Context context;

    public SBMColorPicker(Context context) {
        super(context);
        this.context = context;
        setupColors();
        setUpView();
    }

    public SBMColorPicker(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        setupColors();
        setUpView();
    }

    public SBMColorPicker(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        setupColors();
        setUpView();
    }

    private void setupColors() {
        setUpColor(R.color.RED);
        setUpColor(R.color.PINK);
        setUpColor(R.color.INDIGO);
        setUpColor(R.color.BLUE);
        setUpColor(R.color.GREEN);
        setUpColor(R.color.LIME);
        setUpColor(R.color.YELLOW);
        setUpColor(R.color.ORANGE);
        setUpColor(R.color.BLUE_GREY);
    }

    private void setUpColor(final int color) {
        CircleImageView civ = new CircleImageView(context);
        MarginLayoutParams params = new MarginLayoutParams(fromDp(32), fromDp(32));
        params.setMargins(fromDp(8),fromDp(8),fromDp(8),fromDp(8));
        civ.setLayoutParams(params);
        civ.setImageDrawable(context.getDrawable(color));
        civ.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                onColorSelected(color);
            }
        });
        colors.add(new Pair<>(civ, color));
    }

    private void onColorSelected(int color) {
        for (Pair<CircleImageView, Integer> pair : colors) {
            if (pair.second == color) {
                pair.first.setBorderWidth(fromDp(4));
            }
            else {
                pair.first.setBorderWidth(0);
            }
        }
        for (OnColorSelectedListener listener : listeners) {
            listener.onColorSelected(color);
        }
    }

    private void setUpView() {
        for (Pair<CircleImageView, Integer> pair : colors) {
            addView(pair.first);
        }
    }

    private int fromDp(int dp) {
        Resources r = getResources();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, r.getDisplayMetrics());
    }

    public void setSelectedColor(int color) {
        for (Pair<CircleImageView, Integer> pair : colors) {
            if (pair.second == color) {
                pair.first.setBorderWidth(fromDp(4));
            }
            else {
                pair.first.setBorderWidth(0);
            }
        }
    }

    public void addOnColorSelectedListener(OnColorSelectedListener listener) {
        listeners.add(listener);
    }

    public interface OnColorSelectedListener {
        void onColorSelected(int color);
    }
}
