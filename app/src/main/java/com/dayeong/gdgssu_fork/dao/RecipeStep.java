package com.dayeong.gdgssu_fork.dao;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by IronFactory on 2016. 7. 7..
 */
public class RecipeStep implements Parcelable {

    private static final String PROPERTY_ID = "id";
    private static final String PROPERTY_STEP = "step";
    private static final String PROPERTY_INGREDIENT = "ingredient";
    private static final String PROPERTY_INGREDIENT_AMOUNT = "ingredient_amount";
    private static final String PROPERTY_TIME = "time";
    private static final String PROPERTY_ACTION = "action";

    private int id;
    private int step;
    private String ingredient;
    private String ingredientAmount;
    private int time;
    private String action;


    public RecipeStep(int id, int step, String ingredient, String ingredientAmount, int time, String action) {
        this.id = id;
        this.step = step;
        this.ingredient = ingredient;
        this.ingredientAmount = ingredientAmount;
        this.time = time;
        this.action = action;
    }

    public RecipeStep(Parcel parcel) {
        Bundle bundle = parcel.readBundle();
        id = bundle.getInt(PROPERTY_ID);
        step = bundle.getInt(PROPERTY_STEP);
        ingredient = bundle.getString(PROPERTY_INGREDIENT);
        ingredientAmount = bundle.getString(PROPERTY_INGREDIENT_AMOUNT);
        time = bundle.getInt(PROPERTY_TIME);
        action = bundle.getString(PROPERTY_ACTION);
    }

    public static final Creator<RecipeStep> CREATOR = new Creator<RecipeStep>() {
        @Override
        public RecipeStep createFromParcel(Parcel parcel) {
            return new RecipeStep(parcel);
        }

        @Override
        public RecipeStep[] newArray(int i) {
            return new RecipeStep[i];
        }
    };

    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public String getIngredientAmount() {
        return ingredientAmount;
    }

    public void setIngredientAmount(String ingredientAmount) {
        this.ingredientAmount = ingredientAmount;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
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

    @Override
    public int describeContents() {
        return 0;
    }

    public Bundle getBundle() {
        Bundle bundle = new Bundle();
        bundle.putInt(PROPERTY_ID, id);
        bundle.putInt(PROPERTY_STEP, step);
        bundle.putString(PROPERTY_INGREDIENT, ingredient);
        bundle.putString(PROPERTY_INGREDIENT_AMOUNT, ingredientAmount);
        bundle.putInt(PROPERTY_TIME, time);
        bundle.putString(PROPERTY_ACTION, action);
        return bundle;
    }

    public JSONObject toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put(PROPERTY_STEP, step);
            jsonObject.put(PROPERTY_INGREDIENT, ingredient);
            jsonObject.put(PROPERTY_INGREDIENT_AMOUNT, ingredientAmount);
            jsonObject.put(PROPERTY_TIME, time);
            jsonObject.put(PROPERTY_ACTION, action);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeBundle(getBundle());
    }
}
