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
import com.example.movies.events.OnChangedLoading;
import com.example.movies.events.OnClickItem;
import com.example.movies.events.OnClickItemListener;
import com.example.movies.UI.viewModel.MainViewModel;
import com.example.movies.events.OnClickRefresh;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private boolean firstLoad;
    private MainViewModel mainViewModel;
    private ActivityMainBinding binding;
    private MovieAdapter adapter;
    private LinearLayoutManager layoutManager;
    public static int moviesCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(this.binding.getRoot());
        initUI();
    }

    private void initUI() {
        this.mainViewModel = new MainViewModel();
        this.firstLoad = true;
        onChangedLoading();
        onChangedMovies();
        onClickRefreshListener();
    }

    public void onChangedLoading() {
        this.mainViewModel.isLoading().observe(this, new OnChangedLoading(binding));
    }

    private void onChangedMovies() {
        this.mainViewModel.getMovies().observe(this, new Observer<List<Movie>>() {
            @Override
            public void onChanged(List<Movie> movies) {
                mainViewModel.setLoading(false);

                if(firstLoad) {
                    initList(movies);
                } else {
                    refreshList(movies);
                }

                moviesCount = movies.size();
            }
        });
    }

    private void initList(List<Movie> movies) {
        configLayout();
        configAdapter(movies);
        configRecyclerview();
        this.firstLoad = false;
    }

    private void refreshList(List<Movie> movies) {
        this.adapter.setMovies(movies);
        this.adapter.notifyDataSetChanged();
        this.layoutManager.scrollToPosition(0);
    }

    private void configLayout() {
        int width = this.getResources().getConfiguration().screenWidthDp;
        this.layoutManager = width > 411 ?
                new GridLayoutManager(this, 2) :
                new LinearLayoutManager(this);
    }

    private void configAdapter(List<Movie> movies) {
        this.adapter = new MovieAdapter(movies, new OnClickItem(this));
    }

    private void configRecyclerview() {
        this.binding.recyclerView.setLayoutManager(layoutManager);
        this.binding.recyclerView.setAdapter(adapter);
    }

    private void onClickRefreshListener() {
        this.binding.iBtnRefresh.setOnClickListener(new OnClickRefresh(mainViewModel));
    }
}