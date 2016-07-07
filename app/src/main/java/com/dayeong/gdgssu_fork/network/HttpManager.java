package com.dayeong.gdgssu_fork.network;

import android.util.Log;

import com.dayeong.gdgssu_fork.dao.User;
import com.dayeong.gdgssu_fork.utils.Global;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONException;
import org.json.JSONObject;

import cz.msebera.android.httpclient.Header;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public class HttpManager {

    private static final String TAG = "HttpManager";

    public static void signUp(User user, final HttpListener.OnSignUpListener listener) {

        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Global.SIGN_UP_URL, user.getRequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    Log.d(TAG, "response = " + response);
                    boolean isSuccess = response.getBoolean("join");
                    if (isSuccess)
                        listener.onSuccess();
                    else
                        listener.onException();
                } catch (JSONException e) {
                    listener.onException();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                listener.onException();
                Log.d(TAG, "통신 실패 " + statusCode);
                Log.d(TAG, "통신 실패 " + responseString);
            }
        });
    }

    public static void login(User user, final HttpListener.OnLoginListener onLoginListener) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Global.LOGIN_URL, user.getRequestParams(), new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    boolean isSuccess = response.getBoolean("login");
                    if (isSuccess)
                        onLoginListener.onSuccess();
                    else
                        onLoginListener.onException();
                } catch (JSONException e) {
                    onLoginListener.onException();
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                onLoginListener.onException();
            }
        });
    }

}
