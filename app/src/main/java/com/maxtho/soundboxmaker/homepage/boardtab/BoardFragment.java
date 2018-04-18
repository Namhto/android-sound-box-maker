package com.maxtho.soundboxmaker.homepage.boardtab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.homepage.boardtab.adapter.BoardAdapter;
import com.maxtho.soundboxmaker.model.entity.Board;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.maxtho.soundboxmaker.homepage.boardtab.adapter.BoardAdapter.CONTENT_TYPE;

public class BoardFragment extends Fragment {

    @BindView(R.id.board_list)
    RecyclerView boardList;

    private FloatingActionButton fab;

    private BoardAdapter adapter;

    private OnFragmentInteractionListener mListener;

    public BoardFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_board, container, false);
        ButterKnife.bind(this, view);

        fab = getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //TODO
            }
        });
        fab.show();

        List<Board> list = new ArrayList<>();
        list.add(new Board().setTitle("Politique").setColor(R.color.RED).setImageResId(R.mipmap.politique));
        list.add(new Board().setTitle("Insultes").setColor(R.color.YELLOW).setImageResId(R.mipmap.insulte));
        list.add(new Board().setTitle("Boite à Lopez").setColor(R.color.INDIGO).setImageResId(R.mipmap.lopez));
        list.add(null);
        list.add(new Board().setTitle("Armes").setColor(R.color.GREEN).setImageResId(R.mipmap.arme));
        list.add(new Board().setTitle("Animaux").setColor(R.color.ORANGE).setImageResId(R.mipmap.animaux));
        list.add(null);

        populateBoardList(list);
        configureRecyclerViewBehavior();
        return view;
    }

    private void configureRecyclerViewBehavior() {
        boardList.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (dy > 0) {
                    slideOutNavigationBar();
                } else if (dy < 0) {
                    slideInNavigationBar();
                }
            }
        });

        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(new ItemTouchHelper.Callback() {
            @Override
            public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
                if (viewHolder.getItemViewType() == CONTENT_TYPE) {
                    return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG, ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.START | ItemTouchHelper.END);
                }
                return makeFlag(ItemTouchHelper.ACTION_STATE_IDLE, ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.START | ItemTouchHelper.END);
            }

            @Override
            public boolean onMove(RecyclerView recyclerView, final RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Collections.swap(adapter.getItems(), viewHolder.getAdapterPosition(), target.getAdapterPosition());
                adapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
                return true;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {

            }
        });
        itemTouchHelper.attachToRecyclerView(boardList);
    }

    private void slideInNavigationBar() {
        final BottomNavigationView navigation = getActivity().findViewById(R.id.navigation);
        navigation.clearAnimation();
        navigation.animate().translationY(0).setDuration(300).withStartAction(new Runnable() {
            @Override
            public void run() {
                fab.clearAnimation();
                fab.animate().translationY(0).setDuration(300).withStartAction(new Runnable() {
                    @Override
                    public void run() {
                        fab.show();
                    }
                });
            }
        }).start();
    }

    private void slideOutNavigationBar() {
        final BottomNavigationView navigation = getActivity().findViewById(R.id.navigation);
        navigation.clearAnimation();
        navigation.animate().translationY(navigation.getHeight()).setDuration(300).withStartAction(new Runnable() {
            @Override
            public void run() {
                fab.clearAnimation();
                fab.animate().translationY(navigation.getHeight()).setDuration(300).withEndAction(new Runnable() {
                    @Override
                    public void run() {
                        fab.hide();
                    }
                });
            }
        }).start();
    }

    private void populateBoardList(List<Board> list) {
        adapter = new BoardAdapter(getContext(), list);
        boardList.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        boardList.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
