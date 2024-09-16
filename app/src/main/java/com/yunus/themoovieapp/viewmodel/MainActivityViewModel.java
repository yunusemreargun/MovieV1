package com.yunus.themoovieapp.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.yunus.themoovieapp.model.MoovieRepository;
import com.yunus.themoovieapp.model.Movie;

import java.util.List;

public class MainActivityViewModel extends AndroidViewModel {

private MoovieRepository repository;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        this.repository = new MoovieRepository(application);
    }


    public LiveData<List<Movie>> getAllMovies(){
        return repository.getMutableLiveData();
    }

}
