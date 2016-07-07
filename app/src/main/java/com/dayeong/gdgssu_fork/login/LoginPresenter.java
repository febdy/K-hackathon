package com.dayeong.gdgssu_fork.login;

import android.util.Log;

import com.dayeong.gdgssu_fork.dao.User;
import com.dayeong.gdgssu_fork.network.HttpListener;
import com.dayeong.gdgssu_fork.network.HttpManager;

/**
 * Created by IronFactory on 2016. 7. 4..
 */
public class LoginPresenter implements LoginContract.UserActionsListener {

    private static final String TAG = "LoginPresenter";
    private final LoginContract.View loginView;

    public LoginPresenter(LoginContract.View loginView) {
        this.loginView = loginView;
    }

    @Override
    public void login(String id, String pw) {
        final User user = new User(id, pw);
        HttpManager.login(user, new HttpListener.OnLoginListener() {
            @Override
            public void onSuccess() {
                Log.d(TAG, "로그인 성공");
                loginView.loginSuccess(user);
            }

            @Override
            public void onException() {
                Log.d(TAG, "로그인 실패");
                loginView.loginFail();
            }
        });
    }


    @Override
    public void signup() {
        loginView.signup();
    }
}
