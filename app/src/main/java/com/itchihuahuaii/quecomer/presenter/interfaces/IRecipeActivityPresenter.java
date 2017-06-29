package com.itchihuahuaii.quecomer.presenter.interfaces;

import com.itchihuahuaii.quecomer.pojo.Recipe;

import java.util.ArrayList;

/**
 * Created by usuario1 on 4/26/2017.
 */

public interface IRecipeActivityPresenter {

    public void getRecipesAPI();
    public void showRecipes(ArrayList<Recipe> recipes);

}
