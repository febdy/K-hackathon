package com.dayeong.gdgssu_fork.signup;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public interface SignupContract {

    interface View {

    }


    interface UserActionListener {
        int signup(String id, String pw, String confirm, String email);
    }

}
