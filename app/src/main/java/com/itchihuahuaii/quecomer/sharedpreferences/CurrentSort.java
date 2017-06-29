package com.itchihuahuaii.quecomer.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by usuario1 on 4/29/2017.
 */

public class CurrentSort {

    private static final String PREFERENCE_NAME = "personal_data";
    private static final String PREFERENCE_CURRENT_SORT = "current_sort";

    public static void setCurrentSort(Context context, String sort){
        SharedPreferences myPreference = context.getSharedPreferences(PREFERENCE_NAME,context.MODE_PRIVATE);
        SharedPreferences.Editor editor = myPreference.edit();
        editor.putString(PREFERENCE_CURRENT_SORT,sort);
        editor.commit();
    }

    public static String getCurrentSort(Context context){
        SharedPreferences myPreference = context.getSharedPreferences(PREFERENCE_NAME,context.MODE_PRIVATE);
        String sort = myPreference.getString(PREFERENCE_CURRENT_SORT,"");
        return sort;
    }

}
