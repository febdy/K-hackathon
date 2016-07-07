package com.dayeong.gdgssu_fork.signup;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public interface SignupContract {

    interface View {
        void signUpValid(int code);

        void signUpSuccess();

        void signUpFail();
    }


    interface UserActionListener {
        void signUp(String id, String pw, String confirm, String email);
    }

}
