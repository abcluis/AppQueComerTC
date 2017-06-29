package com.itchihuahuaii.quecomer.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by usuario1 on 4/29/2017.
 */

public class QueryIngredient {

    private static final String PREFERENCE_NAME = "personal_data";
    public static final String PREFERENCE_INGREDIENT = "ingredient_available";

    public static void setIngredientAvailable(Context context, String ingredients){
        SharedPreferences myPreference = context.getSharedPreferences(PREFERENCE_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPreference.edit();
        editor.putString(PREFERENCE_INGREDIENT,ingredients);
        editor.commit();
        CurrentSort.setCurrentSort(context,PREFERENCE_INGREDIENT);
    }

    public static String getIngredientAvailable(Context context){
        SharedPreferences myPreference = context.getSharedPreferences(PREFERENCE_NAME,context.MODE_PRIVATE);
        String ingredients = myPreference.getString(PREFERENCE_INGREDIENT,"");
        return ingredients;
    }

}
