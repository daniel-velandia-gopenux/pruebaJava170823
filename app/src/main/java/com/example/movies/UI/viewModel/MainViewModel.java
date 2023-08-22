package com.example.movies.UI.viewModel;

import android.os.Handler;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.movies.data.model.Movie;
import com.example.movies.domain.GetMoviesUseCase;
import java.util.List;

public class MainViewModel extends ViewModel {

    private GetMoviesUseCase getMoviesUseCase = new GetMoviesUseCase();
    private MutableLiveData<List<Movie>> movies = new MutableLiveData<>();
    private MutableLiveData<Boolean> loading = new MutableLiveData<>();

    public MainViewModel() {
        this.loading.postValue(true);
        simulateServerResponseDelay();
    }

    public void loadMovies() {
        simulateServerResponseDelay();
    }

    public MutableLiveData<List<Movie>> getMovies() {
        return this.movies;
    }

    public MutableLiveData<Boolean> isLoading() {
        return this.loading;
    }

    public void setLoading(Boolean loading) {
        this.loading.postValue(loading);
    }

    private void simulateServerResponseDelay() {
        Handler handler = new Handler();
        int timeOutInMilliseconds = 2000;

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                movies.postValue(getMoviesUseCase.getMovies());
            }
        }, timeOutInMilliseconds);
    }

}
