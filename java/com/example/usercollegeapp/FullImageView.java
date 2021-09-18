package com.example.usercollegeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

public class FullImageView extends AppCompatActivity {
    //This is for selecting Image:->>
    private PhotoView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fullimage_view);

        String image = getIntent().getStringExtra("image");
        imageView = findViewById(R.id.imageView);

        Glide.with(this).load(image).into(imageView);
    }
}