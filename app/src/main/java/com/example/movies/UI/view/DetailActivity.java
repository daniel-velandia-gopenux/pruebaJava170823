package com.example.movies.UI.view;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Environment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.movies.UI.viewModel.DetailViewModel;
import com.example.movies.data.model.Movie;
import com.example.movies.databinding.ActivityDetailBinding;
import com.example.movies.utils.ImageConvert;

import java.io.IOException;
import java.io.InputStream;

public class DetailActivity extends AppCompatActivity {

    private ActivityDetailBinding binding;
    private DetailViewModel detailViewModel;
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
        detailViewModel = new DetailViewModel(movie);
        onChangeMovie();
    }

    private void onChangeMovie() {
        detailViewModel.getMovie().observe(this, new Observer<Movie>() {
            @Override
            public void onChanged(Movie movie) {
                ImageConvert.convertImageToBitmap(binding.getRoot().getContext(),
                        movie.getPhotoPath(), binding.ivMoviePhoto);
                binding.tvMovieTitle.setText(movie.getTitle());
                binding.tvMovieDescription.setText(movie.getDescription());
            }
        });
    }
}