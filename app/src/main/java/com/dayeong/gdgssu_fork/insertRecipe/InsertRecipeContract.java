package com.dayeong.gdgssu_fork.insertRecipe;

import com.dayeong.gdgssu_fork.dao.RecipeGeneral;
import com.dayeong.gdgssu_fork.dao.RecipeStep;

/**
 * Created by IronFactory on 2016. 7. 7..
 */
public interface InsertRecipeContract {

    interface View {

        void insertRecipe(RecipeGeneral recipeGeneral);

        void addRecipe(RecipeGeneral recipeGeneral);

    }

    interface UserActionListener {

        void insertRecipe(RecipeGeneral recipeGeneral, RecipeStep recipeStep);

        void addRecipe(RecipeGeneral recipeGeneral, RecipeStep recipeStep);

    }

}
