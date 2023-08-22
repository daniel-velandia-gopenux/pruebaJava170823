package com.example.movies.data.model;

import android.graphics.Bitmap;

import java.io.Serializable;

public class Movie implements Serializable {

    private String title;
    private String PhotoPath;
    private String description;

    public Movie(String title, String photoPath, String description) {
        this.title = title;
        PhotoPath = photoPath;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPhotoPath() {
        return PhotoPath;
    }

    public void setPhotoPath(String photoPath) {
        PhotoPath = photoPath;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
