package com.example.movies.data;

import com.example.movies.data.model.Movie;
import com.example.movies.data.model.MovieProvider;

import java.util.List;

public class MovieRepository {

    public List<Movie> getMovies() {
        return MovieProvider.getMovies();
    }
}
