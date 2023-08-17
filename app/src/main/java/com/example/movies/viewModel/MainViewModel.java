package com.example.movies.viewModel;

import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.example.movies.model.Movie;
import com.example.movies.model.MoviewProvider;

import java.io.IOException;
import java.util.List;

public class MainViewModel {

    private MutableLiveData<List<Movie>> movies = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();
    private Context context;

    public MainViewModel(Context context) {
        this.context = context;
        this.loading.postValue(true);
        this.movies.postValue(MoviewProvider.getMovies(context));
    }

    public void refreshListMovies() {
        this.movies.postValue(MoviewProvider.getMovies(context));
    }

    public MutableLiveData<List<Movie>> getMovies() {
        return movies;
    }

    public MutableLiveData<Boolean> isLoading() {
        return loading;
    }

    public void setLoading(Boolean loading) {
        this.loading.postValue(loading);
    }
}
