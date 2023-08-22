package com.example.movies.domain;

import com.example.movies.data.MovieRepository;
import com.example.movies.data.model.Movie;
import java.util.ArrayList;
import java.util.List;

public class GetMoviesUseCase {

    private MovieRepository repository = new MovieRepository();

    public List<Movie> getMovies() {

        return this.repository.getMovies();
    }
}
