package com.example.flyhigh;

import static com.example.flyhigh.GameView.screenRatioX;
import static com.example.flyhigh.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Bird {
    public int speed=20;
    public boolean wasShot=true;
    int x = 0, y, width, height, birdCounter = 1;
    Bitmap bird1, bird2, bird3, bird4;

    Bird(Resources res){
        bird1 = BitmapFactory.decodeResource(res, R.drawable.b3a);
        bird2 = BitmapFactory.decodeResource(res, R.drawable.b3a);
        bird3 = BitmapFactory.decodeResource(res, R.drawable.b3b);
        bird4 = BitmapFactory.decodeResource(res, R.drawable.b3b);

        width = bird1.getWidth();
        height = bird1.getHeight();

        width /= 2;
        height /= 2;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        bird1 = Bitmap.createScaledBitmap(bird1, width, height, false);
        bird2 = Bitmap.createScaledBitmap(bird2, width, height, false);
        bird3 = Bitmap.createScaledBitmap(bird3, width, height, false);
        bird4 = Bitmap.createScaledBitmap(bird4, width, height, false);
    }

    Bitmap getBird(){
        if (birdCounter == 1){
            birdCounter++;
            return bird1;
        }
        if (birdCounter == 2){
            birdCounter++;
            return bird2;
        }
        if (birdCounter == 3){
            birdCounter++;
            return bird3;
        }
        birdCounter = 1;
        return bird4;
    }

    Rect getCollisionShape(){
        return new Rect(x,y,x+width,y+height);
    }
}
