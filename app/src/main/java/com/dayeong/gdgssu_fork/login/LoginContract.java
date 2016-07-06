package com.dayeong.gdgssu_fork.login;

import com.dayeong.gdgssu_fork.dao.User;

/**
 * Created by IronFactory on 2016. 7. 4..
 */
public interface LoginContract {

    interface View {
        void loginSuccess(User user);

        void signup();
    }

    interface UserActionsListener {
        void login(String id, String pw);

        void signup();
    }
}
