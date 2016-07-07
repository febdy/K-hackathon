package com.dayeong.gdgssu_fork;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dayeong.gdgssu_fork.views.CircleTimer;

/**
 * Created by Hyemingway on 2016. 7. 4..
 */
public class PageFragment extends Fragment implements CircleTimer.OnTimerListener{

    private int mPageNumber;

    public static PageFragment create(int pageNumber) {
        PageFragment fragment = new PageFragment();
        Bundle args = new Bundle();
        args.putInt("page", pageNumber);
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt("page");
        create(mPageNumber);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_page, container, false);
        ((TextView) rootView.findViewById(R.id.number)).setText(mPageNumber + "");

        return rootView;
    }

    @Override
    public void completeTimer() {
        // next fragment 이동.
    }
}