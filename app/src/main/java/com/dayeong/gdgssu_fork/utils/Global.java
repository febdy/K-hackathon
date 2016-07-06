package com.dayeong.gdgssu_fork.utils;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public class Global {

    public static final String SERVER_URL = "http://k-hack-server.herokuapp.com";
    public static final String SIGNUP_URL = SERVER_URL + "/signup";
    public static final String LOGIN_URL = SERVER_URL + "/login";


    public static final int ERR_EMPTY_ID = 0;
    public static final int ERR_INVALID_ID = 1;
    public static final int ERR_EMPTY_PW = 2;
    public static final int ERR_INVALID_PW = 3;
    public static final int ERR_EMPTY_CONFIRM = 4;
    public static final int ERR_INVALID_CONFIRM = 5;
    public static final int ERR_EMPTY_EMAIL = 6;
    public static final int ERR_INVALID_EMAIL = 7;

    public static final int SUCCESS = 200;


    // Network parameter key
    public static final String ID = "id";
    public static final String PW = "pw";
    public static final String EMAIL = "email";


    // intent key
    public static final String USER = "user";
    public static final String TIMER = "timer";

    // db key
    public static final String SIMPLE_TIMER_DB = "simpleTimer";
}
