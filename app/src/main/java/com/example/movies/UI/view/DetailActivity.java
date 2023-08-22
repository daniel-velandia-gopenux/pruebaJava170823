package com.example.movies.UI.view;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import com.example.movies.UI.viewModel.DetailViewModel;
import com.example.movies.data.model.Movie;
import com.example.movies.databinding.ActivityDetailBinding;
import com.example.movies.utils.ImageConvert;

public class DetailActivity extends AppCompatActivity {

    public static final String MOVIE_EXTRA = "movie";
    private ActivityDetailBinding binding;
    private DetailViewModel detailViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());
        initUI();
    }

    private void initUI() {
        Movie movie = (Movie) getIntent().getSerializableExtra(MOVIE_EXTRA);
        this.detailViewModel = new DetailViewModel(movie);
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