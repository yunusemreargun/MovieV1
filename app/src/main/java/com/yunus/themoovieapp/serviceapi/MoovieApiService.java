package com.yunus.themoovieapp.serviceapi;

import com.yunus.themoovieapp.model.Result;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface MoovieApiService {

    @GET("movie/popular")
    Call<Result> getPopularMoovies(@Query("api_key") String apiKey);
}
