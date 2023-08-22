package com.example.movies.utils;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.widget.ImageView;
import java.io.IOException;
import java.io.InputStream;

public class ImageConvert {

    public static void convertImageToBitmap(Context context ,String imagePath ,ImageView imageView) {
        try {
            getImageBitmap(context, imagePath, imageView);
        } catch (IOException e) {
            final String defaultImagePath = "images/movie-ticket.jpg";
            try {
                getImageBitmap(context, defaultImagePath, imageView);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    private static void getImageBitmap(Context context, String imagePath, ImageView imageView) throws IOException {
        InputStream inputStream = context.getAssets().open(imagePath);
        Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
        imageView.setImageBitmap(bitmap);
    }
}
