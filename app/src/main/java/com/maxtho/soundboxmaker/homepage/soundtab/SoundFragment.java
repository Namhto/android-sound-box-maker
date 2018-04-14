package com.maxtho.soundboxmaker.homepage.soundtab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.homepage.HomePageActivity;
import com.maxtho.soundboxmaker.homepage.soundtab.adapter.SoundCategorieAdapter;
import com.maxtho.soundboxmaker.homepage.soundtab.ui.AddSoundBottomSheetFragment;
import com.maxtho.soundboxmaker.model.entity.Sound;
import com.maxtho.soundboxmaker.model.entity.SoundCategorie;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SoundFragment extends Fragment {

    @BindView(R.id.recyclerview_sounds_list)
    RecyclerView soundCategorieRecyclerView;

    @BindView(R.id.floatingButton_addSound)
    FloatingActionButton floatingActionButtonAddSound;

    private SoundCategorieAdapter soundCategorieAdapter;

    private OnFragmentInteractionListener mListener;

    public SoundFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment SoundFragment.
     */
    public static SoundFragment newInstance() {
        SoundFragment fragment = new SoundFragment();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_sound, container, false);
        ButterKnife.bind(this, v);
        soundCategorieAdapter = new SoundCategorieAdapter(initSounds());
        soundCategorieRecyclerView.setLayoutManager(new LinearLayoutManager(v.getContext()));
        soundCategorieRecyclerView.setAdapter(soundCategorieAdapter);
        soundCategorieRecyclerView.setHasFixedSize(true);

        return v;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    @OnClick(R.id.floatingButton_addSound)
    public void addSound(View view) {
        new AddSoundBottomSheetFragment().show(this.getActivity().getSupportFragmentManager(), "Dialog");
    }

    private List<SoundCategorie> initSounds() {
        Sound s1 = new Sound().setName("TVPALC").setSoundReference(R.raw.poulepondeuse);
        Sound s2 = new Sound().setName("Pssss").setSoundReference(R.raw.quarantecinq);
        Sound s3 = new Sound().setName("um um").setSoundReference(R.raw.poulepondeuse);
        Sound s4 = new Sound().setName("Ui").setSoundReference(R.raw.quarantecinq);

        SoundCategorie sc1 = new SoundCategorie()
                .setTitle("DxP")
                .setSoundList(Arrays.asList(s1, s2, s3, s4));

        Sound s5 = new Sound().setName("a").setSoundReference(R.raw.quarantecinq);
        Sound s6 = new Sound().setName("b").setSoundReference(R.raw.poulepondeuse);
        Sound s7 = new Sound().setName("c").setSoundReference(R.raw.quarantecinq);
        Sound s8 = new Sound().setName("d").setSoundReference(R.raw.poulepondeuse);
        Sound s9 = new Sound().setName("e").setSoundReference(R.raw.quarantecinq);
        Sound s10 = new Sound().setName("f").setSoundReference(R.raw.poulepondeuse);

        SoundCategorie sc2 = new SoundCategorie()
                .setTitle("Repliques")
                .setSoundList(Arrays.asList(s5, s6, s7, s8, s9, s10));

        SoundCategorie sc3 = new SoundCategorie()
                .setTitle("Bruitages")
                .setSoundList(Arrays.asList(s5, s6, s7, s8, s9, s10));

        SoundCategorie sc4 = new SoundCategorie()
                .setTitle("Insultes")
                .setSoundList(Arrays.asList(s5, s6, s7, s8, s9, s10));


        return Arrays.asList(sc1, sc2, sc3, sc4);
    }
}
