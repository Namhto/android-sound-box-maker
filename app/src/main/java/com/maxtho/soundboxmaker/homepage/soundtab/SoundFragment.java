package com.maxtho.soundboxmaker.homepage.soundtab;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.homepage.HomePageActivity;
import com.maxtho.soundboxmaker.homepage.soundtab.adapter.SoundAdapter;
import com.maxtho.soundboxmaker.homepage.soundtab.fragment.AddSoundBottomSheetFragment;
import com.maxtho.soundboxmaker.model.entity.Sound;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SoundFragment extends Fragment {

    private String TAG = "SoundFragment";

    @BindView(R.id.rv_categorie_sounds)
    RecyclerView recyclerViewCategorie;

    private FloatingActionButton fab;

    private Context context;
    private OnFragmentInteractionListener mListener;

    private SoundAdapter categorieRecycleViewAdapter;

    private List<Sound> soundList;

    private MediaPlayer mp;

    public SoundFragment() {
        // Required empty public constructor
    }

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

        fab = getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addSound();
            }
        });
        fab.show();

        context = this.getContext();

        soundList = ((HomePageActivity) getActivity()).sbmManager.getSoundList();

        recyclerViewCategorie.setLayoutManager(new LinearLayoutManager(getContext()));
        categorieRecycleViewAdapter = new SoundAdapter(this.getContext(), soundList);
        recyclerViewCategorie.setAdapter(categorieRecycleViewAdapter);

        recyclerViewCategorie.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    BottomNavigationView navigation = getActivity().findViewById(R.id.navigation);
                    fab.clearAnimation();
                    fab.animate().translationY(navigation.getHeight() * 2).setDuration(300);
                } else if (dy < 0) {
                    fab.clearAnimation();
                    fab.animate().translationY(0).setDuration(300);
                }
            }
        });

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

    @Override
    public void onResume() {
        super.onResume();
        getActivity().invalidateOptionsMenu();
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.options_menu_searchable, menu);

        final MenuItem searchItem = menu.findItem(R.id.action_search);
        final SearchView searchView = (SearchView) searchItem.getActionView();

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                final List<Sound> filteredList = filter(soundList, s);
                categorieRecycleViewAdapter.setSoundList(filteredList);
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private void addSound() {
        new AddSoundBottomSheetFragment().show(this.getActivity().getSupportFragmentManager(), "Dialog");
    }

    private List<Sound> filter(List<Sound> mList, String query) {
        query = query.toLowerCase();
        final List<Sound> filteredList = new ArrayList<>();
        for (Sound sound : mList) {
            for (String label : sound.getLabels()) {
                if (label.toLowerCase().contains(query)) {
                    filteredList.add(sound);
                    break;
                }
            }
        }
        return filteredList;
    }


}
