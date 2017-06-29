package com.itchihuahuaii.quecomer.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by usuario1 on 4/29/2017.
 */

public class QueryMoney {

    private static final String PREFERENCE_NAME = "personal_data";
    public static final String PREFERENCE_MONEY = "money_available";

    public static void setMoneyAvailable(Context context,int money){
        SharedPreferences myPreference = context.getSharedPreferences(PREFERENCE_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPreference.edit();
        editor.putInt(PREFERENCE_MONEY,money);
        editor.commit();
        CurrentSort.setCurrentSort(context,PREFERENCE_MONEY);
    }

    public static int getMoneyAvailable(Context context){
        SharedPreferences myPreference = context.getSharedPreferences(PREFERENCE_NAME,context.MODE_PRIVATE);
        int money = myPreference.getInt(PREFERENCE_MONEY,100);
        return money;
    }


}
