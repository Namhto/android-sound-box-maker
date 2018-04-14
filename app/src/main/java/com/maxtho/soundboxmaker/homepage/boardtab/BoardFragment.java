package com.maxtho.soundboxmaker.homepage.boardtab;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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

    @BindView(R.id.board_list_favorite)
    ListView boardListFavorite;

    @BindView(R.id.board_list)
    ListView boardList;

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
        list.add(new Board().setTitle("Politique").setCount(10).setFavorite(true).setColor(Color.RED));
        list.add(new Board().setTitle("Insultes").setCount(8).setFavorite(true).setColor(Color.BLUE_GREY));
        list.add(new Board().setTitle("Bruitage").setCount(15).setFavorite(false).setColor(Color.BLUE));
        list.add(new Board().setTitle("Bruitage").setCount(15).setFavorite(false).setColor(Color.GREEN));
        list.add(new Board().setTitle("Bruitage").setCount(15).setFavorite(false).setColor(Color.YELLOW));
        list.add(new Board().setTitle("Bruitage").setCount(15).setFavorite(false).setColor(Color.INDIGO));
        list.add(new Board().setTitle("Bruitage").setCount(15).setFavorite(false).setColor(Color.PINK));
        list.add(new Board().setTitle("Bruitage").setCount(15).setFavorite(false).setColor(Color.LIME));
        list.add(new Board().setTitle("Bruitage").setCount(15).setFavorite(false).setColor(Color.TEAL));
        list.add(new Board().setTitle("Bruitage").setCount(15).setFavorite(false).setColor(Color.ORANGE));
        list.add(new Board().setTitle("Bruitage").setCount(15).setFavorite(false).setColor(Color.GREY));

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
        View boardListFavoriteHeader = getLayoutInflater().inflate(R.layout.list_view_favorite_header, boardListFavorite, false);
        boardListFavorite.addHeaderView(boardListFavoriteHeader);
        boardListFavorite.setAdapter(adapterFavorite);
        setListViewHeight(boardListFavorite);

        adapter = new BoardAdapter(getContext(), 0, otherBoardList);
        View boardListHeader = getLayoutInflater().inflate(R.layout.list_view_header, boardList, false);
        boardList.addHeaderView(boardListHeader);
        boardList.setAdapter(adapter);
        setListViewHeight(boardList);

        return view;
    }

    private void setListViewHeight(ListView listView) {
        int totalHeight = 0;
        for (int i = 0; i < listView.getAdapter().getCount(); i++) {
            View listItem = listView.getAdapter().getView(i, null, listView);
            listItem.measure(0, 0);
            totalHeight += listItem.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listView.getAdapter().getCount() - 1));
        listView.setLayoutParams(params);
        listView.requestLayout();
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
