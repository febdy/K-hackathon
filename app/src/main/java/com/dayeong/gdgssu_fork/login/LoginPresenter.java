package com.dayeong.gdgssu_fork.login;

import android.util.Log;

import com.dayeong.gdgssu_fork.utils.Global;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

import cz.msebera.android.httpclient.Header;

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
//        User user = new User(id, pw);

        AsyncHttpClient client = new AsyncHttpClient();
        RequestParams params = new RequestParams();
        params.add("id", "id");
        params.add("pw", "pw");
        client.post(Global.SERVER_URL + "/login", params, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                Log.d(TAG, "success");
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {
                Log.d(TAG, "fail");
            }
        });
    }


    @Override
    public void signup() {
        loginView.signup();
    }
}
