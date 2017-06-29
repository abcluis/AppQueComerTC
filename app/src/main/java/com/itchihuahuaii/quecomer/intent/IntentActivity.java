package com.itchihuahuaii.quecomer.intent;

import android.app.Activity;
import android.content.Intent;

import com.itchihuahuaii.quecomer.IngredientActivity;
import com.itchihuahuaii.quecomer.MoneyAvailableActivity;
import com.itchihuahuaii.quecomer.MoneyOrIngredientActivity;
import com.itchihuahuaii.quecomer.RecipeActivity;
import com.itchihuahuaii.quecomer.sharedpreferences.QueryMoney;

/**
 * Created by usuario1 on 4/29/2017.
 */

public class IntentActivity {


    private static final String MONEY_AVAILABLE = "money_available";

    public static void startRecipeActivity(Activity context){
        Intent intent = new Intent(context, RecipeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        int money = QueryMoney.getMoneyAvailable(context);
        intent.putExtra(MONEY_AVAILABLE,money);
        context.startActivity(intent);
        context.finish();
    }

    public static void startMoneyAvailable(Activity context){
        Intent intent = new Intent(context, MoneyAvailableActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        context.finish();
    }

    public static void startMoneyOrIngredient(Activity context){
        Intent intent = new Intent(context, MoneyOrIngredientActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        context.finish();
    }

    public static void startIngredient(Activity context){
        Intent intent = new Intent(context, IngredientActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        context.finish();
    }
}
