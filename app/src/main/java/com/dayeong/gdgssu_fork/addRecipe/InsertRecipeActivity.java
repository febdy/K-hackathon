package com.dayeong.gdgssu_fork.addRecipe;

import android.os.Bundle;

import com.dayeong.gdgssu_fork.R;
import com.dayeong.gdgssu_fork.views.BaseActivity;

public class InsertRecipeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_insert_recipe_container, new RecipeTitleFragment())
                .commit();
    }
}
