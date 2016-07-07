package com.dayeong.gdgssu_fork.network;

/**
 * Created by IronFactory on 2016. 7. 7..
 */
public class HttpListener {

    public interface OnLoginListener {
        void onSuccess();
        void onException();
    }

    public interface OnSignUpListener {
        void onSuccess();
        void onException();
    }

}
