package com.example.movies.domain;

import android.os.Handler;

import com.example.movies.data.MovieRepository;
import com.example.movies.data.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class GetMoviesUseCase
{
    private MovieRepository repository = new MovieRepository();

    public List<Movie> getMovies() {
        List<Movie> movies = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            movies.addAll(repository.getMovies());
        }

        return movies;
    }
}
