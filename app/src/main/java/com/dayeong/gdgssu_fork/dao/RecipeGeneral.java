package com.dayeong.gdgssu_fork.dao;

import java.util.List;

/**
 * Created by IronFactory on 2016. 7. 7..
 */
public class RecipeGeneral {
    private int id;
    private String name;
    private String author;
    private int like;
    private List<Recipe> recipes;

    public RecipeGeneral(int id, String name, String author, int like, List<Recipe> recipes) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.like = like;
        this.recipes = recipes;
    }

    public List<Recipe> getRecipes() {
        return recipes;
    }

    public void setRecipes(List<Recipe> recipes) {
        this.recipes = recipes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }
}
