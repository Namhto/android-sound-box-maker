package com.maxtho.soundboxmaker.homepage.soundtab;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.homepage.soundtab.adapter.SoundAdapter;
import com.maxtho.soundboxmaker.homepage.soundtab.data.SoundsDataPump;
import com.maxtho.soundboxmaker.homepage.soundtab.fragment.AddSoundBottomSheetFragment;
import com.maxtho.soundboxmaker.model.entity.Sound;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SoundFragment extends Fragment {

    //@BindView(R.id.expandableListView_categorie_sounds)
    //ExpandableListView expandableListView;

    @BindView(R.id.rv_categorie_sounds)
    RecyclerView recyclerViewCategorie;

    @BindView(R.id.floatingButton_addSound)
    FloatingActionButton floatingActionButtonAddSound;

    private Context context;
    List<Sound> listSound;

    /*
    List<String> expandableListTitle;
    HashMap<String, List<Sound>> expandableListDetail;
    */
    private SoundAdapter categorieRecycleViewAdapter;


    private MediaPlayer mp;

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

        context = this.getContext();

        recyclerViewCategorie.setLayoutManager(new LinearLayoutManager(getContext()));
        categorieRecycleViewAdapter = new SoundAdapter(this.getContext(), SoundsDataPump.getData());
        recyclerViewCategorie.setAdapter(categorieRecycleViewAdapter);


        /*
        expandableListDetail = SoundsDataPump.getData();
        expandableListTitle = new ArrayList<String>(expandableListDetail.keySet());
*/

        /*
        CategorieSoundAdapter categorieSoundAdapter = new CategorieSoundAdapter(context, 0, getListData());
        lv_categorieSoundListView.setAdapter(categorieSoundAdapter);
*/


        /*
        SoundCategorieExpandableListAdapter expandableListAdapter = new SoundCategorieExpandableListAdapter(context, expandableListTitle, expandableListDetail);
        expandableListView.setAdapter(expandableListAdapter);
        expandableListView.setOnGroupExpandListener(new ExpandableListView.OnGroupExpandListener() {

            @Override
            public void onGroupExpand(int groupPosition) {
                Toast.makeText(context,
                        expandableListTitle.get(groupPosition) + " List Expanded.",
                        Toast.LENGTH_SHORT).show();
            }
        });

        expandableListView.setOnGroupCollapseListener(new ExpandableListView.OnGroupCollapseListener() {

            @Override
            public void onGroupCollapse(int groupPosition) {
                Toast.makeText(context,
                        expandableListTitle.get(groupPosition) + " List Collapsed.",
                        Toast.LENGTH_SHORT).show();

            }
        });

        expandableListView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v,
                                        int groupPosition, int childPosition, long id) {
                Sound s = expandableListDetail.get(
                        expandableListTitle.get(groupPosition)).get(
                        childPosition);
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
            }
        });

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

}
