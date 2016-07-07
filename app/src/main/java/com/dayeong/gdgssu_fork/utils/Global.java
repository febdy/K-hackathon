package com.dayeong.gdgssu_fork.utils;

/**
 * Created by IronFactory on 2016. 7. 6..
 */
public class Global {

    public static final String SERVER_URL = "http://k-hack-server.herokuapp.com";
    public static final String SIGN_UP_URL = SERVER_URL + "/signup";
    public static final String LOGIN_URL = SERVER_URL + "/login";
    public static final String INSERT_RECIPE_URL = SERVER_URL + "/insert_recipe";


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
    public static final String NAME = "name";
    public static final String RECIPE_NAME = "recipe_name";
    public static final String AUTHOR = "author";


    // intent key
    public static final String USER = "user";
    public static final String TIMER = "timer";
    public static final String TITLE = "title";
    public static final String RECIPE_GENERAL = "recipeGeneral";
    public static final String RECIPE_STEPS = "recipe_steps";

    // db key
    public static final String SIMPLE_TIMER_DB = "simpleTimer";
}
