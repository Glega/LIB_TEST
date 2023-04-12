package com.dreka.best;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.utils.ScreenUtils;



import java.util.Random;

public class MainMenu implements Screen {
    SpriteBatch batch;
    Random rnd;
    ShapeRenderer shapeRenderer;
    Texture backGroundPicture;
    Texture startButton;
    BitmapFont font;
    final String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";
    private Game game;
    TextureRegion textureRegion;
    Sprite vrotaru;
    int angle;
    Animation crow;
    Texture crowTexture;
    Texture branch;
    TextureManager textureManager;


    public MainMenu(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        textureManager = new TextureManager();
        System.out.println("Menu show!");
        batch = new SpriteBatch();
        final String FONT_PATH = "font.otf";
        FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
        FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
        parameter.characters = FONT_CHARS;
        parameter.size = 34;
        parameter.color = Color.BLACK;
        font = generator.generateFont(parameter);
        font.getData().setScale(2.5f);
        angle = 0;

        shapeRenderer = new ShapeRenderer();
        rnd = new Random();
        backGroundPicture = new Texture("main_screen.png");
        startButton = new Texture("start.png");
        textureRegion = new TextureRegion(startButton, 10, 10, 50, 70);
        vrotaru = new Sprite(backGroundPicture);
        vrotaru.setPosition(300, 300);
        crowTexture = new Texture("crow_see.png");
        crow = new Animation(new TextureRegion(crowTexture), 9, -1);
        branch = new Texture("branch.png");
    }

    @Override
    public void render(float delta) {

        //System.out.println(delta);
        ScreenUtils.clear(1, 1, 1, 1);
        angle++;

        batch.begin();
        //batch.draw(backGroundPicture, 100, 100);
        vrotaru.draw(batch);
        //vrotaru.setRotation(angle);
        //batch.draw(branch, 0, 240);
        //batch.draw(crow.getFrame(), 200, 300);
        //batch.draw(startButton, 220, 50);
        crow.update(delta);
        //Вывод текста
        font.draw(batch, "Тыкай в лес!!!", 300, 200);

        batch.end();

        if(Gdx.input.justTouched()){
            game.setScreen(new GameScreen(game));
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
        System.out.println("MainMenu dispose!");
        batch.dispose();
        font.dispose();
        startButton.dispose();
        backGroundPicture.dispose();
        crowTexture.dispose();
        branch.dispose();
    }
}
