package com.example.flyhigh;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.SurfaceView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameView extends SurfaceView implements Runnable{

    private Thread thread;
    private boolean isPlaying, isGameOver=false;
    private int screenX, screenY;
    public static float screenRatioX, screenRatioY;
    private Paint paint;
    private Flight flight;
    private Random random;
    private Bird[] birds;
    private List<Bullet> bullets;
    private Background background1, background2;

    public GameView(Context context, int screenX, int screenY) {
        super(context);

        this.screenX = screenX;
        this.screenY = screenY;

        screenRatioX = 1920f / screenX;
        screenRatioY = 1080f / screenY;

        paint = new Paint();

        background1 = new Background(screenX, screenY, getResources());
        background2 = new Background(screenX, screenY, getResources());

        flight = new Flight(this, screenY, getResources());

        bullets = new ArrayList<>();

        background2.x = screenX;

        birds = new Bird[4];
        for (int i = 0; i<4; i++){
            Bird bird = new Bird(getResources());
            birds[i] = bird;
        }

        random = new Random();
    }

    @Override
    public void run() {
        while (isPlaying){
            update();
            draw();
            sleep();
        }
    }

    private void update(){

        background1.x -= 10 * screenRatioX;
        background2.x -= 10 * screenRatioX;

        if (background1.x + background1.background.getWidth() < 0){
            background1.x = screenX;
        }

        if (background2.x + background2.background.getWidth() < 0){
            background2.x = screenX;
        }

        if (flight.isGoingUp){
            flight.y -= 15 * screenRatioY;
        }else{
            flight.y += 15 * screenRatioY;
        }

        if (flight.y < 0){
            flight.y = 0;
        }

        if(flight.y > screenY - flight.height){
            flight.y = screenY - flight.height;
        }

        List<Bullet> trash = new ArrayList<>();

        for(Bullet bullet: bullets){
            if (bullet.x > screenX){
                trash.add(bullet);
            }
            bullet.x += 50 * screenRatioX;

            for (Bird bird: birds){
                if (Rect.intersects(bird.getCollisionShape(), bullet.getCollisionShape() )){
                    bird.x = -500;
                    bullet.x = screenX+500;
                    bird.wasShot = true;
                }
            }
        }

        for (Bullet bullet: trash){
            bullets.remove(bullet);
        }

        for(Bird bird: birds){
            bird.x -= bird.speed;

            if (bird.x + bird.width < 0){

                if (!bird.wasShot){
                    isGameOver = true;
                    return;
                }
                int bound = (int) (10 * screenRatioX);
                bird.speed = random.nextInt(bound);

                if(bird.speed < 10*screenRatioX){
                    bird.speed = (int) (10*screenRatioX);
                }
                bird.x = screenX;
                bird.y = random.nextInt(screenY - bird.height);

                bird.wasShot = false;
            }

            if (Rect.intersects(bird.getCollisionShape(),flight.getCollisionShape())){
                isGameOver = true;
                return;
            }
        }
    }

    private void draw(){

        if (getHolder().getSurface().isValid()){
            Canvas canvas = getHolder().lockCanvas();
            canvas.drawBitmap(background1.background,background1.x, background1.y, paint);
            canvas.drawBitmap(background2.background,background2.x, background2.y, paint);

            if (isGameOver){
                isPlaying = false;
                canvas.drawBitmap(flight.getDead(), flight.x, flight.y, paint);
                getHolder().unlockCanvasAndPost(canvas);
                return;
            }

            for (Bird bird: birds){
                canvas.drawBitmap(bird.getBird(), bird.x, bird.y, paint);
            }

            canvas.drawBitmap(flight.getFlight(),flight.x, flight.y, paint);

            for(Bullet bullet: bullets){
                canvas.drawBitmap(bullet.bullet, bullet.x, bullet.y, paint);
            }

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void sleep(){
        try {
            Thread.sleep(17);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume(){
        isPlaying = true;
        thread = new Thread(this);
        thread.start();
    }

    public void pause(){
        try {
            isPlaying = false;
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                if (event.getX() < screenX / 2){
                    flight.isGoingUp = true;
                }
                break;
            case MotionEvent.ACTION_UP:
                flight.isGoingUp = false;
                if (event.getX() > screenX / 2){
                    flight.toShoot++;
                }
                break;
        }
        return true;
    }

    public void newBullet() {
        Bullet bullet = new Bullet(getResources());
        bullet.x = flight.x + flight.width;
        bullet.y = flight.y + (flight.height / 2);
        bullets.add(bullet);
    }
}
