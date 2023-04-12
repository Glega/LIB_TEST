package com.dreka.best;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.ScreenUtils;


public class GameScreen implements Screen {
    SpriteBatch batch;
    private BitmapFont font;
    private final Game game;

    Animation crow;
    Texture crowTexture;

    Animal pig;

    Texture sky;
    Texture ground;
    Texture tree;

    Sound crowSound;
    Sound pigSound;

    Music bgSound;

    private Vector3 touchPosition;


    OrthographicCamera camera;

    public GameScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 2130, 1024);

        batch = new SpriteBatch();
        font = new BitmapFont();
        font.setColor(Color.BLACK);
        font.getData().setScale(2.5f);
        crowTexture = new Texture("crow_see.png");
        crow = new Animation(new TextureRegion(crowTexture), 9, -1);

        crowSound = Gdx.audio.newSound(Gdx.files.internal("crow.mp3"));
        pigSound = Gdx.audio.newSound(Gdx.files.internal("pighru.mp3"));


        bgSound = Gdx.audio.newMusic(Gdx.files.internal("summer_sound0.mp3"));

        bgSound.setLooping(true);
        bgSound.play();

        touchPosition = new Vector3();

        //camera = new OrthographicCamera(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 2);
        //camera.position.x = Gdx.graphics.getWidth() / 4;
        //camera.position.y = Gdx.graphics.getHeight() / 4;
        sky = new Texture("sky.png");
        ground = new Texture("ground.png");
        tree = new Texture("tree.png");

        pig = new Animal("animals/pig.png", 3, 5);
    }

    @Override
    public void render(float delta) {
        //String resolution = Gdx.graphics.getWidth() + "x" + Gdx.graphics.getHeight();
        ScreenUtils.clear(1, 1, 1, 1);
        camera.update();

        batch.begin();
        batch.setProjectionMatrix(camera.combined);
        batch.draw(sky, 0, 0);
        batch.draw(ground, 0, 0);
        pig.draw(batch);
        batch.draw(tree, 0, 0);
        batch.draw(crow.getFrame(), 547, 1024 - 700);
        //font.draw(batch, resolution, 100, 500);


        batch.end();

        crow.update(delta);
        pig.update(delta);

        if(Gdx.input.justTouched()){
            //game.setScreen(new MainMenu(game));
            touchPosition.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPosition);
            if(touchPosition.x > 547 && touchPosition.x < 547 + 50 && touchPosition.y > 324 && touchPosition.y < 400){
                crowSound.stop();
                crowSound.play(1.0f);
            }

            if(touchPosition.x > pig.getPosition().x && touchPosition.x < pig.getPosition().x + 250 && touchPosition.y > pig.getPosition().y && touchPosition.y < pig.getPosition().y + 250){
                pigSound.stop();
                pigSound.play();
            }


        }

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
        dispose();
    }

    @Override
    public void dispose() {
        System.out.println("Game dispose!");
        batch.dispose();
        crowTexture.dispose();

        pig.dispose();
        sky.dispose();
        ground.dispose();
        tree.dispose();
        crowSound.dispose();
        bgSound.dispose();
        pigSound.dispose();
    }
}
