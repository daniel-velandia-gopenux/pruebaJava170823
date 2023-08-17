package com.example.movies.view;

import static com.example.movies.view.DetailActivity.MOVIE_EXTRA;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

import com.example.movies.adapter.MovieAdapter;
import com.example.movies.databinding.ActivityMainBinding;
import com.example.movies.events.OnClickListener;
import com.example.movies.model.Movie;
import com.example.movies.model.MoviewProvider;
import com.example.movies.viewModel.MainViewModel;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private ActivityMainBinding binding;

    private MovieAdapter adapter;
    private LinearLayoutManager layoutManager;

    private List<Movie> movies = MoviewProvider.getMovies(this);

    public MainActivity() throws IOException {
        mainViewModel = new MainViewModel(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUI();
    }

    public void loading() {
        mainViewModel.isLoading().observe(this, isLoading -> {
            binding.clLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
            binding.recyclerView.setVisibility(!isLoading ? View.VISIBLE : View.GONE);
        });
    }

    private void initUI() {
        configAdapter();
        configRecyclerview();
        onClickRefreshListener();
    }

    private void configAdapter() {
        adapter = new MovieAdapter(movies, new OnClickListener() {
            @Override
            public void onClickListener(Movie movie) {
                goDetailView(movie);
            }
        });
    }

    private void configRecyclerview() {
        binding.recyclerView.setLayoutManager(layoutManager);
        binding.recyclerView.setAdapter(adapter);
    }

    private void goDetailView(Movie movie) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(MOVIE_EXTRA, movie);
        startActivity(intent);

    }

    private void loading(boolean loading) {
        if(loading) {
            binding.tvMoviesCount.setText("Loading movies...");
            binding.recyclerView.setVisibility(View.GONE);
            binding.clLoading.setVisibility(View.VISIBLE);
        } else {
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    binding.clLoading.setVisibility(View.GONE);
                    binding.tvMoviesCount.setText("Movies: " + movies.size());
                    binding.recyclerView.setVisibility(View.VISIBLE);
                }
            }, 1000);

        }
    }

    private void onClickRefreshListener() {
        binding.iBtnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                movies = MoviewProvider.getMovies(binding.getRoot().getContext());
                adapter.notifyDataSetChanged();
                layoutManager.scrollToPosition(0);
            }
        });
    }
}