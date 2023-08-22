package com.example.movies.events;

import android.view.View;

import androidx.lifecycle.Observer;

import com.example.movies.UI.view.MainActivity;
import com.example.movies.databinding.ActivityMainBinding;

public class OnChangedLoading implements Observer<Boolean> {

    private final String movieCount = "Movies: ";
    private final String loadingCount = "Loading movies...";
    private ActivityMainBinding binding;

    public OnChangedLoading(ActivityMainBinding binding) {
        this.binding = binding;
    }

    @Override
    public void onChanged(Boolean isLoading) {
        binding.clLoading.setVisibility(isLoading ? View.VISIBLE : View.GONE);
        binding.recyclerView.setVisibility(!isLoading ? View.VISIBLE : View.GONE);
        binding.tvMoviesCount.setText(!isLoading ? movieCount + MainActivity.moviesCount : loadingCount);
    }
}
