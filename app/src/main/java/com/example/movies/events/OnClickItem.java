package com.example.movies.events;

import static com.example.movies.UI.view.DetailActivity.MOVIE_EXTRA;

import android.content.Context;
import android.content.Intent;

import com.example.movies.UI.view.DetailActivity;
import com.example.movies.data.model.Movie;

public class OnClickItem implements OnClickItemListener{
    private Context context;

    public OnClickItem(Context context) {
        this.context = context;
    }

    @Override
    public void onClickListener(Movie movie) {
        Intent intent = new Intent(context, DetailActivity.class);
        intent.putExtra(MOVIE_EXTRA, movie);
        context.startActivity(intent);
    }
}
