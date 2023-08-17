package com.example.movies.model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private Bitmap Photo;
    private String description;

    public Movie(String title, Bitmap photo, String description) {
        this.title = title;
        Photo = photo;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Bitmap getPhoto() {
        return Photo;
    }

    public void setPhoto(Bitmap photo) {
        Photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
