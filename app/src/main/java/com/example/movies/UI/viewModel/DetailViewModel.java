package com.example.movies.UI.viewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.example.movies.data.model.Movie;

public class DetailViewModel extends ViewModel {

    private MutableLiveData<Movie> movie = new MutableLiveData<>();

    public DetailViewModel(Movie movie) {
        this.movie.postValue(movie);
    }

    public MutableLiveData<Movie> getMovie() {
        return this.movie;
    }
}
