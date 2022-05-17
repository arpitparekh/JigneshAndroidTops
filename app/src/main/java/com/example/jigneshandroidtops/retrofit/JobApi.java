package com.example.jigneshandroidtops.retrofit;

import com.example.jigneshandroidtops.retrofit.classes.Job;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface JobApi {

    @GET("api/jobs")
    @Headers("Authorization: Token 6aa92aaa9883feab9eebb70372d71e4b16349fd7")
    Call<Job> getJobData(@Query("location")String location);

}
