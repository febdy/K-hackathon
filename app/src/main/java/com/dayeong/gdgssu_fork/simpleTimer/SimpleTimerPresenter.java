package com.dayeong.gdgssu_fork.simpleTimer;

import android.util.Log;

import com.dayeong.gdgssu_fork.dao.Timer;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public class SimpleTimerPresenter implements SimpleTimerContract.UserActionListener {

    private static final String TAG = "SimpleTimerPresenter";
    private SimpleTimerContract.View simpleTimerView;

    public SimpleTimerPresenter(SimpleTimerContract.View simpleTimerView) {
        this.simpleTimerView = simpleTimerView;
    }

    @Override
    public void startTimer(Timer timer) {
        Log.d(TAG, "startTimer");
        simpleTimerView.startTimer(timer);
    }
}
