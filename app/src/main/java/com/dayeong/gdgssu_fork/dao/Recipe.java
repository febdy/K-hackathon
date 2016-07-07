package com.dayeong.gdgssu_fork.dao;

/**
 * Created by IronFactory on 2016. 7. 7..
 */
public class Recipe {
    private int id;
    private int step;
    private String action;

    public Recipe(int id, int step, String action) {
        this.id = id;
        this.step = step;
        this.action = action;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
