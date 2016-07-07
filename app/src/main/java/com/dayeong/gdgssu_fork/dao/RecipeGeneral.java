package com.dayeong.gdgssu_fork.dao;

import com.dayeong.gdgssu_fork.utils.Global;
import com.loopj.android.http.RequestParams;

import org.json.JSONArray;

import java.io.Serializable;
import java.util.List;

/**
 * Created by IronFactory on 2016. 7. 7..
 */
public class RecipeGeneral implements Serializable {

    private int id;
    private String name;
    private String author;
    private int like;
    private List<RecipeStep> recipeSteps;

    public RecipeGeneral(int id, String name, String author, int like, List<RecipeStep> recipeSteps) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.like = like;
        this.recipeSteps = recipeSteps;
    }

    public List<RecipeStep> getRecipeSteps() {
        return recipeSteps;
    }

    public void setRecipeSteps(List<RecipeStep> recipeSteps) {
        this.recipeSteps = recipeSteps;
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

    public RequestParams getRequestParams() {
        RequestParams params = new RequestParams();
        params.put(Global.NAME, name);
        params.put(Global.AUTHOR, author);
        JSONArray array = new JSONArray();
        for (RecipeStep step : recipeSteps) {
            array.put(step.toJson());
        }
        params.put(Global.RECIPE_STEPS, recipeSteps);
        return params;
    }
}
