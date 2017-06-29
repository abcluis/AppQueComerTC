package com.itchihuahuaii.quecomer.presenter.interfaces;

/**
 * Created by usuario1 on 4/28/2017.
 */

public interface IRecipeDetailActivityPresenter {
    public void getIngredientsByRecipe(int recipe_id);
    public void showIngredientsRecycler();
}
