package com.itchihuahuaii.quecomer.restAPI.adapter;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.itchihuahuaii.quecomer.restAPI.EndPoints;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by usuario1 on 4/27/2017.
 */

public class RestApiAdapter {

    public EndPoints establecerConexionAPI(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://afternoon-plains-28611.herokuapp.com/api/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        return retrofit.create(EndPoints.class);
    }

    public Gson generateGson(){
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

}
