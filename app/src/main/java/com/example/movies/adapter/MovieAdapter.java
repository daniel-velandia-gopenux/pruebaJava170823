package com.example.movies.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.movies.databinding.ItemMovieLayoutBinding;
import com.example.movies.events.OnClickItemListener;
import com.example.movies.data.model.Movie;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieViewHolder> {

    private List<Movie> movies;
    private OnClickItemListener listener;

    public MovieAdapter(List<Movie> movies, OnClickItemListener listener) {
        this.movies = movies;
        this.listener = listener;
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemMovieLayoutBinding binding = ItemMovieLayoutBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new MovieViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, int position) {
        holder.render(this.movies.get(position), this.listener);
    }

    @Override
    public int getItemCount() {
        return this.movies.size();
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }
}
