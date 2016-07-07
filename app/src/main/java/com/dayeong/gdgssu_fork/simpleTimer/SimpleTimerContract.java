package com.dayeong.gdgssu_fork.simpleTimer;

import com.dayeong.gdgssu_fork.dao.Timer;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public interface SimpleTimerContract {

    interface View {
        void startTimer(Timer timer);
    }


    interface UserActionListener {
        void startTimer(Timer timer);
    }

}
