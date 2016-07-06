package com.dayeong.gdgssu_fork.network;

import com.dayeong.gdgssu_fork.dao.User;
import com.dayeong.gdgssu_fork.utils.Global;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public class HttpManager {


    public static void signup(User user, AsyncHttpResponseHandler handler) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Global.SIGNUP_URL, user.getRequestParams(), handler);
    }

}
