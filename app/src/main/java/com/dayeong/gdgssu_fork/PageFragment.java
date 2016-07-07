package com.dayeong.gdgssu_fork;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.dayeong.gdgssu_fork.dao.Timer;
import com.dayeong.gdgssu_fork.timer.TimerFragment;

/**
 * Created by Hyemingway on 2016. 7. 4..
 */
public class PageFragment extends Fragment{

    private static final String TAG = "PAGE_FRAGMENT";
    private int mPageNumber;

    private TimerFragment mTimerFragment;


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

        mTimerFragment = TimerFragment.newInstance(new Timer("dd", 10), mPageNumber);
        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
        transaction.attach(mTimerFragment);
        transaction.commit();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_page, container, false);
        ((TextView) rootView.findViewById(R.id.recipe_contents)).setText("no." + mPageNumber);

        return rootView;
    }
}