package com.example.jigneshandroidtops.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {

    public static JobApi getApiInstance(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://findwork.dev/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JobApi api = retrofit.create(JobApi.class);

        return api;

    }

}
