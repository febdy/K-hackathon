package com.dayeong.gdgssu_fork;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dayeong.gdgssu_fork.views.BaseFragment;

import java.util.ArrayList;

/**
 * Created by Dayeong on 2016-07-07.
 */
public class MainFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        init(view);
        return view;
    }

    @Override
    protected void init(View view) {
        mLayoutManager = new LinearLayoutManager(getActivity());

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(mLayoutManager);

        ArrayList<String> recipeList = new ArrayList<>();
        recipeList.add("감자");
        recipeList.add("고구마");
        recipeList.add("호박고구마");
        recipeList.add("오이");
        recipeList.add("당근");
        recipeList.add("양파");
        recipeList.add("마늘");
        recipeList.add("냠냠");
        recipeList.add("맛있오");

        mAdapter = new RecipeAdapter(getActivity(), recipeList);
        mRecyclerView.setAdapter(mAdapter);
    }
}
