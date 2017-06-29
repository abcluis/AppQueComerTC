package com.itchihuahuaii.quecomer.restAPI;

import com.itchihuahuaii.quecomer.pojo.Ingredient;
import com.itchihuahuaii.quecomer.pojo.IngredientRecipe;
import com.itchihuahuaii.quecomer.pojo.Recipe;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by usuario1 on 4/27/2017.
 */

public interface EndPoints {

    @GET("recipe/")
    Call<List<Recipe>> getRecipes(@Query("maxValue") int maxValue);

    @GET("ingredient-recipe/{recipe_id}")
    Call<List<Ingredient>> getIngredientsRecipe(@Path("recipe_id") int recipe_id);

    @GET("ingredient-recipe/")
    Call<List<Recipe>> getRecipeByIngredients(@Query("ingredients_id") String ingredients_id);

    @GET("ingredient/")
    Call<List<Ingredient>> getIngredients();

}
