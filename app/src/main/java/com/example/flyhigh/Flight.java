package com.example.flyhigh;

import static com.example.flyhigh.GameView.screenRatioX;
import static com.example.flyhigh.GameView.screenRatioY;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;

public class Flight {

    int toShoot=0;
    int x, y, width, height, wingCounter = 0, shootCounter=1;
    boolean isGoingUp = false;
    Bitmap flight1, flight2, shoot1, shoot2, shoot3, shoot4, shoot5, dead;
    private GameView gameView;

    Flight(GameView gameView, int screenY, Resources res){

        this.gameView = gameView;
        flight1 = BitmapFactory.decodeResource(res, R.drawable.p1a);
        flight2 = BitmapFactory.decodeResource(res, R.drawable.p1b);

        width = flight1.getWidth();
        height = flight2.getHeight();

        width /= 4;
        height /= 4;

        width = (int) (width * screenRatioX);
        height = (int) (height * screenRatioY);

        flight1 = Bitmap.createScaledBitmap(flight1, width, height, false);
        flight2 = Bitmap.createScaledBitmap(flight2, width, height, false);

        shoot1 = BitmapFactory.decodeResource(res, R.drawable.p1c);
        shoot2 = BitmapFactory.decodeResource(res, R.drawable.p1d);
        shoot3 = BitmapFactory.decodeResource(res, R.drawable.p1e);
        shoot4 = BitmapFactory.decodeResource(res, R.drawable.p1f);
        shoot5 = BitmapFactory.decodeResource(res, R.drawable.p1g);

        shoot1 = Bitmap.createScaledBitmap(shoot1, width, height, false);
        shoot2 = Bitmap.createScaledBitmap(shoot2, width, height, false);
        shoot3 = Bitmap.createScaledBitmap(shoot3, width, height, false);
        shoot4 = Bitmap.createScaledBitmap(shoot4, width, height, false);
        shoot5 = Bitmap.createScaledBitmap(shoot5, width, height, false);

        dead = BitmapFactory.decodeResource(res,R.drawable.p1h);
        dead = Bitmap.createScaledBitmap(dead, width, height, false);

        y = screenY / 2;
        x = (int) (64 * screenRatioX);

    }

    Bitmap getFlight(){
        if (toShoot != 0){
            if (shootCounter == 1){
                shootCounter++;
                return shoot1;
            }
            if (shootCounter == 2){
                shootCounter++;
                return shoot2;
            }
            if (shootCounter == 3){
                shootCounter++;
                return shoot3;
            }
            if (shootCounter == 4){
                shootCounter++;
                return shoot4;
            }

            shootCounter = 1;
            toShoot--;
            gameView.newBullet();

            return shoot5;
        }

        if (wingCounter == 0){
            wingCounter++;
            return flight1;
        }
        wingCounter--;
        return flight2;
    }

    Rect getCollisionShape(){
        return new Rect(x,y,x+width,y+height);
    }

    Bitmap getDead(){
        return dead;
    }
}
