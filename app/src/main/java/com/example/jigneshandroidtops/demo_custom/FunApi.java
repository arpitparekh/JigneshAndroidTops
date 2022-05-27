package com.example.jigneshandroidtops.demo_custom;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface FunApi {

    @GET("demo")
    @Headers("demo: demo")
    Call<List<Fun>> getData(@Query("demo")String demo);


    @GET("demo")
    @Headers("demo: demo")
    Call<Goa> getData2(@Query("demo")String demo);
}
