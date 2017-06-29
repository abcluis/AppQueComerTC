package com.itchihuahuaii.quecomer.Interfaces;

import com.itchihuahuaii.quecomer.pojo.Ingredient;

import java.util.ArrayList;

/**
 * Created by usuario1 on 4/28/2017.
 */

public interface IRecipeDetailActivity {
    public void generarLinearLayout();
    public void initializeAdapter(ArrayList<Ingredient> ingredients);

}
