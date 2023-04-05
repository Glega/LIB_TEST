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

public class GameScreen implements Screen {
    SpriteBatch batch;
    private Game game;

    Animation crow;
    Texture crowTexture;
    Texture branch;

    public GameScreen(Game game) {
        this.game = game;
    }

    @Override
    public void show() {
        System.out.println("Game start!");
        batch = new SpriteBatch();

        crowTexture = new Texture("crow_see.png");
        crow = new Animation(new TextureRegion(crowTexture), 9, -1);
        branch = new Texture("branch.png");
    }

    @Override
    public void render(float delta) {
        ScreenUtils.clear(1, 1, 1, 1);


        batch.begin();

        batch.draw(branch, 0, 240);
        batch.draw(crow.getFrame(), 200, 300);

        crow.update(delta);
        batch.end();


        if(Gdx.input.justTouched()){
            game.setScreen(new MainMenu(game));
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
        branch.dispose();
    }
}
