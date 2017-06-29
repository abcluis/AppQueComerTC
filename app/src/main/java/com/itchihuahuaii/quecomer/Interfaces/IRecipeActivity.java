package com.itchihuahuaii.quecomer.Interfaces;

import com.itchihuahuaii.quecomer.pojo.Recipe;

import java.util.ArrayList;

/**
 * Created by usuario1 on 4/26/2017.
 */

public interface IRecipeActivity {

    public void generateGridLayout();
    public void initializeAdapter(ArrayList<Recipe> recipes);
}
