package com.example.movies.events;

import android.view.View;

import com.example.movies.UI.viewModel.MainViewModel;

public class OnClickRefresh implements View.OnClickListener{

    private MainViewModel mainViewModel;

    public OnClickRefresh(MainViewModel mainViewModel) {
        this.mainViewModel = mainViewModel;
    }

    @Override
    public void onClick(View view) {
        mainViewModel.setLoading(true);
        mainViewModel.loadMovies();
    }
}
