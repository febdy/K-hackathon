package com.dayeong.gdgssu_fork.addRecipe;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;

import com.dayeong.gdgssu_fork.R;
import com.dayeong.gdgssu_fork.dao.RecipeGeneral;
import com.dayeong.gdgssu_fork.dao.RecipeStep;
import com.dayeong.gdgssu_fork.utils.Global;
import com.dayeong.gdgssu_fork.views.BaseFragment;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

/**
 * 레시피 추가
 */
public class InsertRecipeFragment extends BaseFragment implements InsertRecipeContract.View {

    private static final String TAG = "AddRecipeFragment";

    private EditText ingredientInput;
    private EditText ingredientAmountInput;
    private EditText actionInput;

    private NumberPicker minPicker;
    private NumberPicker secPicker;

    private Button submitBtn;
    private Button moreBtn;

    private int minutes;
    private int seconds;

    private RecipeGeneral recipeGeneral;
    private int step;

    private InsertRecipeContract.UserActionListener listener;

    public static InsertRecipeFragment newInstance(RecipeGeneral recipeGeneral, int step) {
        InsertRecipeFragment fragment = new InsertRecipeFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Global.RECIPE_GENERAL, recipeGeneral);
        bundle.putInt(Global.RECIPE_STEPS, step);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        recipeGeneral = (RecipeGeneral) getArguments().getSerializable(Global.RECIPE_GENERAL);
        step = getArguments().getInt(Global.RECIPE_STEPS);
    }

    public InsertRecipeFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_insert_recipe, container, false);
        init(view);
        return view;
    }


    @Override
    protected void init(View view) {
        listener = new InsertRecipePresenter(this);

        ingredientInput = (EditText) view.findViewById(R.id.fragment_insert_recipe_ingredient);
        ingredientAmountInput = (EditText) view.findViewById(R.id.fragment_insert_recipe_ingredient_amount);
        actionInput = (EditText) view.findViewById(R.id.fragment_insert_recipe_action);

        minPicker = (NumberPicker) view.findViewById(R.id.fragment_insert_recipe_min);
        secPicker = (NumberPicker) view.findViewById(R.id.fragment_insert_recipe_sec);

        minPicker.setMaxValue(59);
        minPicker.setMinValue(0);
        minPicker.setWrapSelectorWheel(true);

        secPicker.setMaxValue(59);
        secPicker.setMinValue(0);
        secPicker.setWrapSelectorWheel(true);

        setListener();
    }

    private void setListener() {
        minPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int value) {
                minutes = value;
            }
        });

        secPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int value) {
                seconds = value;
            }
        });

        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ingredient = ingredientInput.getText().toString();
                String ingredientAmount = ingredientAmountInput.getText().toString();
                String action = actionInput.getText().toString();

                if (ingredient.isEmpty())
                    ingredient = null;
                if (ingredientAmount.isEmpty())
                    ingredientAmount = null;
                if (action.isEmpty())
                    action = null;

                RecipeStep recipeStep = new RecipeStep(0, step, ingredient, ingredientAmount, minutes * 60 + seconds, action);
                listener.insertRecipe(recipeGeneral, recipeStep);
            }
        });

        moreBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String ingredient = ingredientInput.getText().toString();
                String ingredientAmount = ingredientAmountInput.getText().toString();
                String action = actionInput.getText().toString();

                if (ingredient.isEmpty())
                    ingredient = null;
                if (ingredientAmount.isEmpty())
                    ingredientAmount = null;
                if (action.isEmpty())
                    action = null;

                RecipeStep recipeStep = new RecipeStep(0, step, ingredient, ingredientAmount, minutes * 60 + seconds, action);
                listener.addRecipe(recipeGeneral, recipeStep);
            }
        });
    }

    @Override
    public void insertRecipe(RecipeGeneral recipeGeneral) {
        AsyncHttpClient client = new AsyncHttpClient();
        client.post(Global.INSERT_RECIPE_URL, recipeGeneral.getRequestParams(), new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }

    @Override
    public void addRecipe(RecipeGeneral recipeGeneral) {
        getActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.activity_insert_recipe_container, InsertRecipeFragment.newInstance(recipeGeneral, ++step))
                .addToBackStack(null)
                .commit();
    }
}
