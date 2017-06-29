package com.itchihuahuaii.quecomer.presenter;

import android.content.Context;
import android.util.Log;

import com.itchihuahuaii.quecomer.Interfaces.IRecipeActivity;
import com.itchihuahuaii.quecomer.pojo.Recipe;
import com.itchihuahuaii.quecomer.presenter.interfaces.IRecipeActivityPresenter;
import com.itchihuahuaii.quecomer.restAPI.EndPoints;
import com.itchihuahuaii.quecomer.restAPI.adapter.RestApiAdapter;
import com.itchihuahuaii.quecomer.sharedpreferences.CurrentSort;
import com.itchihuahuaii.quecomer.sharedpreferences.QueryIngredient;
import com.itchihuahuaii.quecomer.sharedpreferences.QueryMoney;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by usuario1 on 4/26/2017.
 */

public class RecipeActivityPresenter implements IRecipeActivityPresenter{

    private ArrayList<Recipe> recipes;
    private Context context;
    private IRecipeActivity iRecipeActivity;


    public RecipeActivityPresenter(IRecipeActivity iRecipeActivity,Context context){
        this.iRecipeActivity = iRecipeActivity;
        this.context = context;
        //getIngredientsRecipe();
        getRecipesAPI();
        //dummyData();
    }

    public void dummyData(){
        ArrayList<Recipe> recipes = new ArrayList<>();
        for(int i=0;i<30;i++){
            Recipe recipe = new Recipe();
            recipe.setName("Name : " + i);
            recipe.setDescription("Description : " + i);
            recipes.add(recipe);
        }
        showRecipes(recipes);
    }

    @Override
    public void getRecipesAPI() {

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPoints endPoints = restApiAdapter.establecerConexionAPI(restApiAdapter.generateGson());

        Call< List<Recipe>> call;
        if(CurrentSort.getCurrentSort(context).equals(QueryMoney.PREFERENCE_MONEY)){
            call = endPoints.getRecipes(QueryMoney.getMoneyAvailable(context));
        }else {
            call = endPoints.getRecipeByIngredients(QueryIngredient.getIngredientAvailable(context));
        }
        call.enqueue(new Callback<List<Recipe>>() {
            @Override
            public void onResponse(Call<List<Recipe>> call, Response<List<Recipe>> response) {
                ArrayList<Recipe> recipes = (ArrayList<Recipe>) response.body();
                showRecipes(recipes);

            }

            @Override
            public void onFailure(Call<List<Recipe>> call, Throwable t) {
                Log.e("Error",t.toString());
            }
        });

    }

    @Override
    public void showRecipes(ArrayList<Recipe> recipes) {
        iRecipeActivity.initializeAdapter(recipes);
        iRecipeActivity.generateGridLayout();
    }
}
