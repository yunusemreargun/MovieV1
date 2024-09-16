package com.yunus.themoovieapp.model;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.yunus.themoovieapp.R;
import com.yunus.themoovieapp.serviceapi.MoovieApiService;
import com.yunus.themoovieapp.serviceapi.RetrofitInstances;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoovieRepository {
    private ArrayList<Movie>moovies=new ArrayList<>();
    private MutableLiveData<List<Movie>> mutableLiveData=new MutableLiveData<>();
    private Application application;

    public MoovieRepository(Application application) {
        this.application = application;
    }

    public MutableLiveData<List<Movie>> getMutableLiveData() {
        MoovieApiService moovieApiService= RetrofitInstances.getService();

        Call<Result> call=moovieApiService.
                getPopularMoovies(application.getApplicationContext().getString(R.string.api_key));
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {

                Result result=response.body();
                if (result != null && result.getResults() != null){

                    moovies = (ArrayList<Movie>) result.getResults();
                    mutableLiveData.setValue(moovies);

                }
            }

            @Override
            public void onFailure(Call<Result> call, Throwable throwable) {

            }
        });
        return mutableLiveData;
    }
}
