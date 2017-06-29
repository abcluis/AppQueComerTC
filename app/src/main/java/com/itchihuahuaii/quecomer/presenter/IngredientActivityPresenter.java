package com.itchihuahuaii.quecomer.presenter;

import android.content.Context;
import android.util.Log;

import com.itchihuahuaii.quecomer.Interfaces.IIngredientActivity;
import com.itchihuahuaii.quecomer.pojo.Ingredient;
import com.itchihuahuaii.quecomer.presenter.interfaces.IIngredientActivityPresenter;
import com.itchihuahuaii.quecomer.restAPI.EndPoints;
import com.itchihuahuaii.quecomer.restAPI.adapter.RestApiAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by usuario1 on 4/29/2017.
 */

public class IngredientActivityPresenter implements IIngredientActivityPresenter {

    ArrayList<Ingredient> ingredients;
    Context context;
    IIngredientActivity iIngredientActivity;

    public IngredientActivityPresenter(Context context, IIngredientActivity iIngredientActivity){
        this.context = context;
        this.iIngredientActivity = iIngredientActivity;
        getIngredientsAPI();
    }

    @Override
    public void getIngredientsAPI() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndPoints endPoints = restApiAdapter.establecerConexionAPI(restApiAdapter.generateGson());
        Call< List<Ingredient>> call = endPoints.getIngredients();
        call.enqueue(new Callback<List<Ingredient>>() {
            @Override
            public void onResponse(Call<List<Ingredient>> call, Response<List<Ingredient>> response) {
                ingredients = (ArrayList<Ingredient>) response.body();
                showIngredientsRecycler(ingredients);
            }

            @Override
            public void onFailure(Call<List<Ingredient>> call, Throwable t) {
                Log.e("Error", t.toString());
            }
        });
    }

    @Override
    public void showIngredientsRecycler(ArrayList<Ingredient> ingredients) {
        iIngredientActivity.initializeAdapter(ingredients);
        iIngredientActivity.generateGridLayout();
    }
}
