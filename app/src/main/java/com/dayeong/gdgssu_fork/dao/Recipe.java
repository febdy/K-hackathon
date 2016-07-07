package com.dayeong.gdgssu_fork.dao;

/**
 * Created by IronFactory on 2016. 7. 7..
 */
public class Recipe {

    private String content;
    private String comment;
    private Timer timer;

    public Recipe(String content, String comment, Timer timer) {
        this.content = content;
        this.comment = comment;
        this.timer = timer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
}
