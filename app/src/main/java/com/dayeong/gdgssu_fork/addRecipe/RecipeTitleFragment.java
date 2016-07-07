package com.dayeong.gdgssu_fork.addRecipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.dayeong.gdgssu_fork.R;
import com.dayeong.gdgssu_fork.dao.RecipeGeneral;
import com.dayeong.gdgssu_fork.dao.RecipeStep;
import com.dayeong.gdgssu_fork.utils.Global;
import com.dayeong.gdgssu_fork.views.BaseFragment;

import java.util.ArrayList;

/**
 * 레시피 추가 타잍
 */
public class RecipeTitleFragment extends BaseFragment {

    private RecipeGeneral recipeGeneral;

    private String userId;
    private EditText nameInput;
    private Button submitBtn;

    public RecipeTitleFragment() {
        // Required empty public constructor
    }

    public static RecipeTitleFragment newInstancce(String userId) {
        RecipeTitleFragment fragment = new RecipeTitleFragment();
        Bundle bundle = new Bundle();
        bundle.putString(Global.USER, userId);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        userId = getArguments().getString(Global.USER);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recipe_title, container, false);
        init(view);
        return view;
    }


    @Override
    protected void init(View view) {
        nameInput = (EditText) view.findViewById(R.id.fragment_recipe_title_name);
        submitBtn = (Button) view.findViewById(R.id.fragment_recipe_title_submit);

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = nameInput.getText().toString();
                if (name.isEmpty()) {
                    nameInput.setError(getString(R.string.err_empty_name));
                    return;
                }
                recipeGeneral = new RecipeGeneral(0, name, userId, 0, new ArrayList<RecipeStep>());

                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.activity_insert_recipe_container, InsertRecipeFragment.newInstance(recipeGeneral, 1))
                        .addToBackStack(null)
                        .commit();
            }
        });
    }
}
