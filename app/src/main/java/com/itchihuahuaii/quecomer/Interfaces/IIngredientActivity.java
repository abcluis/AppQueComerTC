package com.itchihuahuaii.quecomer.Interfaces;

import com.itchihuahuaii.quecomer.pojo.Ingredient;

import java.util.ArrayList;

/**
 * Created by usuario1 on 4/29/2017.
 */

public interface IIngredientActivity {
    public void generateGridLayout();
    public void initializeAdapter(ArrayList<Ingredient> ingredients);
}
