package com.dreka.best;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;

import java.util.Iterator;
import java.util.Random;

public class Temp_Main extends ApplicationAdapter {
    SpriteBatch batch;
    OrthographicCamera camera;
    Texture img;
    Texture bear;
    Rectangle bearObj;
    int jopa = 0;
    Texture frame;
    Array<Rectangle> bears;
    Random rnd;
    int screenWidth;
    int screenHeight;


    public Temp_Main(int screenWidth, int screenHeight) {
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
    }

    @Override
    public void create () {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, screenWidth, screenHeight);

        batch = new SpriteBatch();
        img = new Texture("badlogic.jpg");
        bear = new Texture("bear.png");
        frame = new Texture("bearFrame.png");
        rnd = new Random();

        bears = new Array<>();
        for(int i=0; i < 300; i++){
            Rectangle br = new Rectangle();
            br.height = 250;
            br.width = rnd.nextInt(400) + 200;
            br.x = rnd.nextInt(300) + screenWidth + 250;
            br.y = rnd.nextInt(screenHeight);
            bears.add(br);
        }
        System.out.println(Gdx.graphics.getWidth());
        bearObj = new Rectangle();
        bearObj.width = 250;
        bearObj.height = 250;
        bearObj.x = 250;
        bearObj.y = 20;
    }

    @Override
    public void render () {
        ScreenUtils.clear(1, 0, 0, 1);
        camera.update();
        batch.begin();
        for (Rectangle bear: bears){
            batch.draw(frame, bear.x, bear.y);
        }
        batch.draw(frame, bearObj.x, bearObj.y);
        batch.end();
        bearObj.x -= 3;

        Iterator<Rectangle> iter = bears.iterator();
        while (iter.hasNext()){
            Rectangle br = iter.next();
            br.x -= br.width * Gdx.graphics.getDeltaTime();
            //System.out.println(Gdx.graphics.getDeltaTime());
            if(br.x < -250) br.x = rnd.nextInt(300) + screenWidth + 250;
        }
    }

    @Override
    public void dispose () {
        super.dispose();
        batch.dispose();
        img.dispose();
        bear.dispose();
        frame.dispose();
    }
}
