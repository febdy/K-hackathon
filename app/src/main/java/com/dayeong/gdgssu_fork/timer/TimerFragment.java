package com.dayeong.gdgssu_fork.timer;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dayeong.gdgssu_fork.R;
import com.dayeong.gdgssu_fork.dao.Timer;
import com.dayeong.gdgssu_fork.utils.Global;
import com.dayeong.gdgssu_fork.views.BaseFragment;
import com.dayeong.gdgssu_fork.views.CircleTimer;

/**
 * 타이머
 */
public class TimerFragment extends BaseFragment {

    private Timer timer;
    private CircleTimer circleTimerView;

    public TimerFragment() {
        // Required empty public constructor
    }

    public static TimerFragment newInstance(Timer timer) {
        TimerFragment fragment = new TimerFragment();
        Bundle args = new Bundle();
        args.putSerializable(Global.TIMER, timer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            timer = (Timer) getArguments().getSerializable(Global.TIMER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_timer, container, false);
        init(view);
        return view;
    }


    @Override
    protected void init(View view) {
        circleTimerView = (CircleTimer) view.findViewById(R.id.fragment_timer_circle_timer);
        circleTimerView.setMaxTime(10);
        circleTimerView.setCurrentTime(0);
    }
}
