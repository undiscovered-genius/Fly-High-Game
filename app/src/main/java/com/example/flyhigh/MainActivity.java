package com.example.flyhigh;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ImageView playButton;
    private boolean isMute;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.play);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,GameActivity.class);
                startActivity(intent);
            }
        });

        TextView highSocreText = findViewById(R.id.highScoreText);
        SharedPreferences prefs = getSharedPreferences("game", MODE_PRIVATE);
        highSocreText.setText("HighScore: "+prefs.getInt("highScore",0));

        isMute = prefs.getBoolean("isMute",false);

        ImageView volumeControl = findViewById(R.id.volumeControl);

        if (isMute){
            volumeControl.setImageResource(R.drawable.ic_volume_up_24);
        }else{
            volumeControl.setImageResource(R.drawable.ic_volume_off_24);
        }

        volumeControl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                isMute = !isMute;
                if (isMute){
                    volumeControl.setImageResource(R.drawable.ic_volume_up_24);
                }else{
                    volumeControl.setImageResource(R.drawable.ic_volume_off_24);
                }
                SharedPreferences.Editor editor = prefs.edit();
                editor.putBoolean("isMute", isMute);
                editor.apply();
            }
        });

    }
}