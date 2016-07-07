package com.dayeong.gdgssu_fork.simpleTimer;

import android.os.Bundle;

import com.dayeong.gdgssu_fork.R;
import com.dayeong.gdgssu_fork.views.BaseActivity;

public class SimpleTimerActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_timer);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_simple_timer_container, new SimpleTimerFragment())
                .commit();
    }
}
