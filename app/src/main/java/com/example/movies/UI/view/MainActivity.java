package com.example.movies.UI.view;

import static com.example.movies.UI.view.DetailActivity.MOVIE_EXTRA;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.movies.adapter.MovieAdapter;
import com.example.movies.data.model.Movie;
import com.example.movies.databinding.ActivityMainBinding;
import com.example.movies.events.OnClickListener;
import com.example.movies.UI.viewModel.MainViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private MainViewModel mainViewModel;
    private ActivityMainBinding binding;
    private MovieAdapter adapter;
    private LinearLayoutManager layoutManager;
    private boolean firstLoad = true;
    private int moviesCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initUI();
    }

    private void initUI() {
        mainViewModel = new MainViewModel();
        onChangedLoading();
        onChangedMovies();
        onClickRefreshListener();
    }

    public void onChangedLoading() {
        mainViewModel.isLoading().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean isLoading) {
                binding.clLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
                binding.recyclerView.setVisibility(!isLoading ? View.VISIBLE : View.GONE);
                binding.tvMoviesCount.setText(!isLoading ? "Movies: " + moviesCount :
                        "Loading movies..." );
            }
        });
    }

    private void onChangedMovies() {
        mainViewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                mainViewModel.setLoading(false);
                if(firstLoad) initList(movies); else refreshList(movies);
                moviesCount = movies.size();
            }
        });
    }

    private void initList(List<Movie> movies) {
        configLayout();
        configAdapter(movies);
        configRecyclerview();
        firstLoad = false;
    }

    private void refreshList(List<Movie> movies) {
        adapter.setMovies(movies);
        layoutManager.scrollToPosition(0);
    }

    private void configLayout() {
        int width = this.getResources().getConfiguration().screenWidthDp;
        layoutManager = width > 411 ?
                new GridLayoutManager(this, 2) :
                new LinearLayoutManager(this);

    }

    private void configAdapter(List<Movie> movies) {
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

    private void onClickRefreshListener() {
        binding.iBtnRefresh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mainViewModel.setLoading(true);
                mainViewModel.loadMovies();
            }
        });
    }
}