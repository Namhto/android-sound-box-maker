package com.maxtho.soundboxmaker.homepage.soundtab.fragment;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.ui.RecordSoundDialogFragment;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddSoundBottomSheetFragment extends BottomSheetDialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.dialog_add_sound, container, false);
        ButterKnife.bind(this, v);
        return v;
    }

    @OnClick(R.id.constraintLayoutAddFromFile)
    public void addSoundFromFile(View view) {
        Log.d("SoundFragment","addFromFile");
    }

    @OnClick(R.id.constraintLayoutAddFromMic)
    public void addSoundFromMic(View view) {
        Log.d("SoundFragment","addFromMic");
        showEditDialog();
    }

    @OnClick(R.id.constraintLayoutAddFromInternet)
    public void addSoundFromInternet(View view) {
        Log.d("SoundFragment","addFromInternet");
    }

    private void showEditDialog() {
        FragmentManager fm = getActivity().getFragmentManager();
        RecordSoundDialogFragment builder = RecordSoundDialogFragment.newInstance("Some Title");
        builder.show(fm, "fragment_edit_name");
    }


}
