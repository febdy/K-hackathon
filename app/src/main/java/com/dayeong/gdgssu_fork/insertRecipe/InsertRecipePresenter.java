package com.dayeong.gdgssu_fork.insertRecipe;

import com.dayeong.gdgssu_fork.dao.RecipeGeneral;
import com.dayeong.gdgssu_fork.dao.RecipeStep;

/**
 * Created by IronFactory on 2016. 7. 7..
 */
public class InsertRecipePresenter implements InsertRecipeContract.UserActionListener {

    private InsertRecipeContract.View addRecipeView;

    public InsertRecipePresenter(InsertRecipeContract.View addRecipeView) {
        this.addRecipeView = addRecipeView;
    }

    @Override
    public void insertRecipe(RecipeGeneral recipeGeneral, RecipeStep recipeStep) {
        recipeGeneral.getRecipeSteps().add(recipeStep);
        addRecipeView.insertRecipe(recipeGeneral);
    }

    @Override
    public void addRecipe(RecipeGeneral recipeGeneral, RecipeStep recipeStep) {
        recipeGeneral.getRecipeSteps().add(recipeStep);
        addRecipeView.addRecipe(recipeGeneral);
    }
}
