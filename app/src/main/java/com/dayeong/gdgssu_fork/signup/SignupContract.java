package com.dayeong.gdgssu_fork.signup;

import com.dayeong.gdgssu_fork.dao.User;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public interface SignupContract {

    interface View {
        void signUpValid(int code);

        void signUp(User user);
    }


    interface UserActionListener {
        void signUp(String id, String pw, String confirm, String email);
    }

}
