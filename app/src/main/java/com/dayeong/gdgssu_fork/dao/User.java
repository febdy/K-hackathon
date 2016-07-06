package com.dayeong.gdgssu_fork.dao;

import com.dayeong.gdgssu_fork.utils.Global;
import com.loopj.android.http.RequestParams;

/**
 * Created by IronFactory on 2016. 7. 4..
 */
public class User {
    private String id;
    private String pw;
    private String email;

    public User() {
    }

    public User(String id, String pw) {
        this.id = id;
        this.pw = pw;
    }

    public User(String id, String pw, String email) {
        this.id = id;
        this.pw = pw;
        this.email = email;
    }

    public String getPw() {
        return pw;
    }

    public void setPw(String pw) {
        this.pw = pw;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("id : ").append(id)
                .append("pw : ").append(pw)
                .append("email : ").append(email)
                .append("}");
        return sb.toString();
    }

    public RequestParams getRequestParams() {
        RequestParams params = new RequestParams();
        params.add(Global.ID, id);
        params.add(Global.PW, pw);
        params.add(Global.EMAIL, email);
        return params;
    }
}
