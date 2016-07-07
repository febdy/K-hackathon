package com.dayeong.gdgssu_fork.dao;

import java.io.Serializable;

/**
 * Created by IronFactory on 2016. 7. 7..
 */
public class Timer extends RecipeGeneral implements Serializable {

    private String name;
    private long time;

    public Timer(String name, long time) {
        this.name = name;
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String title) {
        this.name = title;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{")
                .append("name = " + name)
                .append(", time = " + name)
                .append("}");
        return sb.toString();
    }
}
