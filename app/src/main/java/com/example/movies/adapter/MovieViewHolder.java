package com.example.movies.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.movies.databinding.ItemMovieLayoutBinding;
import com.example.movies.events.OnClickListener;
import com.example.movies.data.model.Movie;
import com.example.movies.utils.ImageConvert;

public class MovieViewHolder extends RecyclerView.ViewHolder {

    private ItemMovieLayoutBinding binding;
    public MovieViewHolder(@NonNull ItemMovieLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void render(Movie movie, OnClickListener listener) {
        ImageConvert.convertImageToBitmap(binding.getRoot().getContext(), movie.getPhotoPath(),
                binding.ivMoviePhoto);
        binding.tvMovieTitle.setText(movie.getTitle());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onClickListener(movie);
            }
        });
    }
}
