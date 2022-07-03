package com.example.flyhigh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.bumptech.glide.Glide;
import com.jsibbold.zoomage.ZoomageView;

public class BirdActivity extends AppCompatActivity {

    private ViewFlipper viewFlipper;
    private ImageView next, prev, back;
    private ZoomageView img1, img2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_bird);

        viewFlipper = findViewById(R.id.viewFlipper);
        img1 = findViewById(R.id.IMg1);
        img2 = findViewById(R.id.IMg2);
        back = findViewById(R.id.BAckL);
        next = findViewById(R.id.NexT);
        prev = findViewById(R.id.PreV);

        SharedPreferences prefs = getSharedPreferences("bird", MODE_PRIVATE);

        //Glide to load image
        Glide.with(BirdActivity.this).load(R.drawable.b3a).into(img1);
        Glide.with(BirdActivity.this).load(R.drawable.b1a).into(img2);

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
                editor.putInt("bird",score);
                editor.apply();
                Toast.makeText(BirdActivity.this, "Bird Selected", Toast.LENGTH_SHORT).show();
            }
        });

        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img2.setBackgroundResource(R.drawable.selected);
                int score=2;
                SharedPreferences.Editor editor = prefs.edit();
                editor.putInt("bird",score);
                editor.apply();
                Toast.makeText(BirdActivity.this, "Bird Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }
}