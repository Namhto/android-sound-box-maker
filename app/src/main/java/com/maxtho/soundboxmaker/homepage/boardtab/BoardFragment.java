package com.maxtho.soundboxmaker.homepage.boardtab;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.TextView;

import com.maxtho.soundboxmaker.R;
import com.maxtho.soundboxmaker.homepage.boardtab.adapter.BoardAdapter;
import com.maxtho.soundboxmaker.model.entity.Board;
import com.maxtho.soundboxmaker.model.entity.Color;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class BoardFragment extends Fragment {

    private static final float BOARD_LIST_COLUMN_WIDTH = 100;

    @BindView(R.id.board_list_favorite)
    GridView boardListFavorite;

    @BindView(R.id.board_list_favorite_empty)
    TextView boardListFavoriteEmpty;

    @BindView(R.id.board_list)
    GridView boardList;

    @BindView(R.id.board_scrollview)
    NestedScrollView boardScrollView;

    @BindView(R.id.board_add_fab)
    FloatingActionButton boardAddFab;

    private BoardAdapter adapterFavorite;

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

        List<Board> list = new ArrayList<>();
        list.add(new Board().setTitle("Politique").setFavorite(false).setColor(Color.RED).setImageResId(R.mipmap.politique));
        list.add(new Board().setTitle("Insultes").setFavorite(false).setColor(Color.BLUE_GREY));
        list.add(new Board().setTitle("Bruitage").setFavorite(false).setColor(Color.BLUE));
        list.add(new Board().setTitle("Bruitage").setFavorite(false).setColor(Color.GREEN));
        list.add(new Board().setTitle("Bruitage").setFavorite(false).setColor(Color.YELLOW));
        list.add(new Board().setTitle("Bruitage").setFavorite(false).setColor(Color.INDIGO));
        list.add(new Board().setTitle("Bruitage").setFavorite(false).setColor(Color.PINK));
        list.add(new Board().setTitle("Bruitage").setFavorite(false).setColor(Color.LIME));
        list.add(new Board().setTitle("Bruitage").setFavorite(false).setColor(Color.TEAL));
        list.add(new Board().setTitle("Bruitage").setFavorite(false).setColor(Color.ORANGE));
        list.add(new Board().setTitle("Bruitage").setFavorite(false).setColor(Color.GREY));

        populateBoardList(list);
        configureScrollViewBehavior();
        return view;
    }


    private void configureScrollViewBehavior() {
        boardScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                if (scrollY - oldScrollY > 0) {
                    boardAddFab.hide();
                } else {
                    boardAddFab.show();
                }
            }
        });
    }

    private void populateBoardList(List<Board> list) {
        List<Board> favoriteBoardList = new ArrayList<>();
        List<Board> otherBoardList = new ArrayList<>();
        Iterator<Board> iterator = list.iterator();
        while (iterator.hasNext()) {
            Board board = iterator.next();
            if (board.isFavorite()) {
                favoriteBoardList.add(board);
            } else {
                otherBoardList.add(board);
            }
        }

        adapterFavorite = new BoardAdapter(getContext(), 0, favoriteBoardList);
        boardListFavorite.setAdapter(adapterFavorite);
        setGridViewDimensions(boardListFavorite);

        adapter = new BoardAdapter(getContext(), 0, otherBoardList);
        boardList.setAdapter(adapter);
        setGridViewDimensions(boardList);

        if (!favoriteBoardList.isEmpty()) {
            boardListFavoriteEmpty.setVisibility(View.GONE);
        }
    }

    private int convertDpToPixels(float dp, Context context){
        Resources resources = context.getResources();
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, resources.getDisplayMetrics());
    }

    private void setGridViewDimensions(GridView gridView) {
        if (gridView.getAdapter().getCount() > 0) {
            DisplayMetrics displayMetrics = getContext().getResources().getDisplayMetrics();
            float dpWidth = displayMetrics.widthPixels / displayMetrics.density;
            int gridColumnNumber = (int) Math.floor(dpWidth / BOARD_LIST_COLUMN_WIDTH);
            gridView.setNumColumns(gridColumnNumber);

            int gridRowNumber = (int) Math.floor(gridView.getAdapter().getCount() / gridColumnNumber) + 1;
            View listItem = gridView.getAdapter().getView(0, null, gridView);
            listItem.measure(0, 0);

            ViewGroup.LayoutParams params = gridView.getLayoutParams();
            params.height = listItem.getMeasuredHeight() * gridRowNumber;
            gridView.setLayoutParams(params);
            gridView.requestLayout();
        }
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
