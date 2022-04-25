package com.example.flyhigh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.jsibbold.zoomage.ZoomageView;

public class LocationActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private ImageView next, prev, back;
    private ZoomageView img1, img2, img3, img4, img5, img6, img7, img8, img9, img10, img11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_location);

        viewFlipper = findViewById(R.id.viewFlipper);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        img3 = findViewById(R.id.img3);
        img4 = findViewById(R.id.img4);
        img5 = findViewById(R.id.img5);
        img6 = findViewById(R.id.img6);
        img7 = findViewById(R.id.img7);
        img8 = findViewById(R.id.img8);
        img9 = findViewById(R.id.img9);
        img10 = findViewById(R.id.img10);
        img11 = findViewById(R.id.img11);
        back = findViewById(R.id.backL);
        next = findViewById(R.id.next);
        prev = findViewById(R.id.prev);

        SharedPreferences prefs = getSharedPreferences("location", MODE_PRIVATE);

        //Glide to load image
        Glide.with(LocationActivity.this).load(R.drawable.d6).into(img1);
        Glide.with(LocationActivity.this).load(R.drawable.d2).into(img2);
        Glide.with(LocationActivity.this).load(R.drawable.d5).into(img3);
        Glide.with(LocationActivity.this).load(R.drawable.d7).into(img4);
        Glide.with(LocationActivity.this).load(R.drawable.d8).into(img5);
        Glide.with(LocationActivity.this).load(R.drawable.d9).into(img6);
        Glide.with(LocationActivity.this).load(R.drawable.e1).into(img7);
        Glide.with(LocationActivity.this).load(R.drawable.n1).into(img8);
        Glide.with(LocationActivity.this).load(R.drawable.n2).into(img9);
        Glide.with(LocationActivity.this).load(R.drawable.n4).into(img10);
        Glide.with(LocationActivity.this).load(R.drawable.n6).into(img11);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
                finish();
            }
        });

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showNext();
            }
        });

        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewFlipper.showPrevious();
            }
        });

        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img1.setBackgroundResource(R.drawable.selected);
                int score = 1;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("location",score);
                editor.apply();
                Toast.makeText(LocationActivity.this, "Location Selected", Toast.LENGTH_SHORT).show();
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img2.setBackgroundResource(R.drawable.selected);
                int score=2;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("location",score);
                editor.apply();
                Toast.makeText(LocationActivity.this, "Location Selected", Toast.LENGTH_SHORT).show();
            }
        });

        img3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img3.setBackgroundResource(R.drawable.selected);
                int score=3;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("location",score);
                editor.apply();
                Toast.makeText(LocationActivity.this, "Location Selected", Toast.LENGTH_SHORT).show();
            }
        });

        img4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img4.setBackgroundResource(R.drawable.selected);
                int score=4;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("location",score);
                editor.apply();
                Toast.makeText(LocationActivity.this, "Location Selected", Toast.LENGTH_SHORT).show();
            }
        });

        img5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img5.setBackgroundResource(R.drawable.selected);
                int score=5;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("location",score);
                editor.apply();
                Toast.makeText(LocationActivity.this, "Location Selected", Toast.LENGTH_SHORT).show();
            }
        });

        img6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img6.setBackgroundResource(R.drawable.selected);
                int score=6;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("location",score);
                editor.apply();
                Toast.makeText(LocationActivity.this, "Location Selected", Toast.LENGTH_SHORT).show();
            }
        });

        img7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img7.setBackgroundResource(R.drawable.selected);
                int score=7;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("location",score);
                editor.apply();
                Toast.makeText(LocationActivity.this, "Location Selected", Toast.LENGTH_SHORT).show();
            }
        });

        img8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img8.setBackgroundResource(R.drawable.selected);
                int score=8;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("location",score);
                editor.apply();
                Toast.makeText(LocationActivity.this, "Location Selected", Toast.LENGTH_SHORT).show();
            }
        });

        img9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img9.setBackgroundResource(R.drawable.selected);
                int score=9;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("location",score);
                editor.apply();
                Toast.makeText(LocationActivity.this, "Location Selected", Toast.LENGTH_SHORT).show();
            }
        });

        img10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img10.setBackgroundResource(R.drawable.selected);
                int score=10;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("location",score);
                editor.apply();
                Toast.makeText(LocationActivity.this, "Location Selected", Toast.LENGTH_SHORT).show();
            }
        });

        img11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img11.setBackgroundResource(R.drawable.selected);
                int score=11;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("location",score);
                editor.apply();
                Toast.makeText(LocationActivity.this, "Location Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}