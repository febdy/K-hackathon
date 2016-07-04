package com.dayeong.gdgssu_fork.dao;

/**
 * Created by IronFactory on 2016. 7. 4..
 */
public class User {
    private String id;
    private String pw;

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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("id : ").append(id)
                .append("pw : ").append(pw)
                .append("}");
        return sb.toString();
    }
}
