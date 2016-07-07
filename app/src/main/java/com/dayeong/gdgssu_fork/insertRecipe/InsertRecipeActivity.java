package com.dayeong.gdgssu_fork.insertRecipe;

import android.os.Bundle;

import com.dayeong.gdgssu_fork.R;
import com.dayeong.gdgssu_fork.dao.User;
import com.dayeong.gdgssu_fork.views.BaseActivity;

public class InsertRecipeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_recipe);

        User user = new User("test55", "test55");

        getSupportFragmentManager().beginTransaction()
                .add(R.id.activity_insert_recipe_container, RecipeTitleFragment.newInstancce(user.getId()))
                .commit();
    }
}
