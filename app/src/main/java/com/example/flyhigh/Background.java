package com.example.flyhigh;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class Background {

    int x=0, y=0;
    Bitmap background;

    Background(int location, int screenX, int screenY, Resources res){


        if (location == 1){
            background = BitmapFactory.decodeResource(res,R.drawable.d6);
            background = Bitmap.createScaledBitmap(background, screenX, screenY,false);
        }else if (location == 2){
            background = BitmapFactory.decodeResource(res,R.drawable.d2);
            background = Bitmap.createScaledBitmap(background, screenX, screenY,false);
        }else if (location == 3){
            background = BitmapFactory.decodeResource(res,R.drawable.d5);
            background = Bitmap.createScaledBitmap(background, screenX, screenY,false);
        }else if (location == 4){
            background = BitmapFactory.decodeResource(res,R.drawable.d7);
            background = Bitmap.createScaledBitmap(background, screenX, screenY,false);
        }else if (location == 5){
            background = BitmapFactory.decodeResource(res,R.drawable.d8);
            background = Bitmap.createScaledBitmap(background, screenX, screenY,false);
        }else if (location == 6){
            background = BitmapFactory.decodeResource(res,R.drawable.d9);
            background = Bitmap.createScaledBitmap(background, screenX, screenY,false);
        }else if (location == 7){
            background = BitmapFactory.decodeResource(res,R.drawable.e1);
            background = Bitmap.createScaledBitmap(background, screenX, screenY,false);
        }else if (location == 8){
            background = BitmapFactory.decodeResource(res,R.drawable.n1);
            background = Bitmap.createScaledBitmap(background, screenX, screenY,false);
        }else if (location == 9){
            background = BitmapFactory.decodeResource(res,R.drawable.n2);
            background = Bitmap.createScaledBitmap(background, screenX, screenY,false);
        }else if (location == 10){
            background = BitmapFactory.decodeResource(res,R.drawable.n4);
            background = Bitmap.createScaledBitmap(background, screenX, screenY,false);
        }else{
            background = BitmapFactory.decodeResource(res,R.drawable.n6);
            background = Bitmap.createScaledBitmap(background, screenX, screenY,false);
        }

    }
}
