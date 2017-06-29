package com.itchihuahuaii.quecomer.presenter;

import android.content.Context;

import com.itchihuahuaii.quecomer.Interfaces.IRecipeDetailActivity;
import com.itchihuahuaii.quecomer.pojo.Ingredient;
import com.itchihuahuaii.quecomer.presenter.interfaces.IRecipeDetailActivityPresenter;
import com.itchihuahuaii.quecomer.restAPI.EndPoints;
import com.itchihuahuaii.quecomer.restAPI.adapter.RestApiAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by usuario1 on 4/28/2017.
 */

public class RecipeDetailActivityPresenter implements IRecipeDetailActivityPresenter{

    private ArrayList<Ingredient> ingredients;
    private IRecipeDetailActivity iRecipeDetailActivity;
    private Context context;

    public RecipeDetailActivityPresenter(Context context, IRecipeDetailActivity iRecipeDetailActivity,int recipe_id){
        this.context = context;
        this.iRecipeDetailActivity = iRecipeDetailActivity;
        //getIngredientDummy();
        getIngredientsByRecipe(recipe_id);
    }

    public void getIngredientDummy(){
        ingredients = new ArrayList<Ingredient>();
        for(int i=0;i<40;i++){
            Ingredient ingredient = new Ingredient();
            ingredient.setName("Ingrediente " + i);
            ingredients.add(ingredient);
        }
        showIngredientsRecycler();
    }

    @Override
    public void getIngredientsByRecipe(int recipe_id) {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPoints endPoints = restApiAdapter.establecerConexionAPI(restApiAdapter.generateGson());

        Call<List<Ingredient>> call = endPoints.getIngredientsRecipe(recipe_id);
        call.enqueue(new Callback<List<Ingredient>>() {
            @Override
            public void onResponse(Call<List<Ingredient>> call, Response<List<Ingredient>> response) {
                ingredients = (ArrayList<Ingredient>) response.body();
                showIngredientsRecycler();
            }

            @Override
            public void onFailure(Call<List<Ingredient>> call, Throwable t) {

            }
        });

    }

    @Override
    public void showIngredientsRecycler() {
        iRecipeDetailActivity.initializeAdapter(ingredients);
        iRecipeDetailActivity.generarLinearLayout();
    }
}
