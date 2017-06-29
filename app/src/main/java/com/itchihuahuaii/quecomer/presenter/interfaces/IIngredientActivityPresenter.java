package com.itchihuahuaii.quecomer.presenter.interfaces;

import com.itchihuahuaii.quecomer.pojo.Ingredient;

import java.util.ArrayList;

/**
 * Created by usuario1 on 4/29/2017.
 */

public interface IIngredientActivityPresenter {
    public void getIngredientsAPI();
    public void showIngredientsRecycler(ArrayList<Ingredient> ingredients);
}
