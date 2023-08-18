package com.example.movies.domain;

import android.os.Handler;

import com.example.movies.data.MovieRepository;
import com.example.movies.data.model.Movie;
import java.util.List;

public class GetMoviesUseCase {

    private MovieRepository repository = new MovieRepository();

    public List<Movie> getMovies() {
        return repository.getMovies();
    }
}
