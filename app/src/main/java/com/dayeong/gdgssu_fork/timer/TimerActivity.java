package com.dayeong.gdgssu_fork.timer;

import android.os.Bundle;
import android.util.Log;

import com.dayeong.gdgssu_fork.R;
import com.dayeong.gdgssu_fork.dao.Timer;
import com.dayeong.gdgssu_fork.utils.Global;
import com.dayeong.gdgssu_fork.views.BaseActivity;
import com.dayeong.gdgssu_fork.views.CircleTimer;

public class TimerActivity extends BaseActivity implements CircleTimer.OnTimerListener {

    private static final String TAG = "TimerActivity";
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        timer = (Timer) getIntent().getSerializableExtra(Global.TIMER);
        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_timer_container, TimerFragment.newInstance(timer))
                .commit();
    }


    @Override
    public void completeTimer() {
        Log.d(TAG, "완료");
    }
}
