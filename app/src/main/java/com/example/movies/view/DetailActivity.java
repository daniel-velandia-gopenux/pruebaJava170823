package com.example.movies.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.movies.R;
import com.example.movies.databinding.ActivityDetailBinding;
import com.example.movies.model.Movie;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;

    public static final String MOVIE_EXTRA = "movie";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUI();
    }

    private void initUI() {
        Movie movie = (Movie) getIntent().getSerializableExtra(MOVIE_EXTRA);

        binding.ivMoviePhoto.setImageBitmap(movie.getPhoto());
        binding.tvMovieTitle.setText(movie.getTitle());
        binding.tvMovieDescription.setText(movie.getDescription());
    }
}