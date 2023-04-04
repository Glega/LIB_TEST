package com.dreka.best;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.ScreenUtils;




import java.util.Iterator;
import java.util.Random;

public class MainScreen extends ApplicationAdapter {
	SpriteBatch batch;
	Random rnd;
	ShapeRenderer shapeRenderer;
	Texture backGroundPicture;
	Texture startButton;
	BitmapFont font;
	int screenWidth;
	int screenHeight;
	final String FONT_CHARS = "абвгдеёжзийклмнопрстуфхцчшщъыьэюяabcdefghijklmnopqrstuvwxyzАБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЪЫЬЭЮЯABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789][_!$%#@|\\/?-+=()*&.;:,{}\"´`'<>";



	public MainScreen(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;
	}

	@Override
	public void create () {
		batch = new SpriteBatch();
		System.out.println(Gdx.files);

		final String FONT_PATH = "font.otf";
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal(FONT_PATH));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.characters = FONT_CHARS;
		parameter.size = 15;
		parameter.color = Color.BLACK;
		font = generator.generateFont(parameter);

		shapeRenderer = new ShapeRenderer();
		rnd = new Random();
		backGroundPicture = new Texture("main_screen.png");
		startButton = new Texture("start.png");
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);

		batch.begin();
		batch.draw(backGroundPicture, 100, 100);
		batch.draw(startButton, 220, 50);
		font.draw(batch, "Привет and Hello", 100, 100);

		batch.end();

		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.setColor(0, 1, 0, 1);
		shapeRenderer.line(0,0, 100,100);
		shapeRenderer.end();


	}
	
	@Override
	public void dispose () {
		super.dispose();
		batch.dispose();
		font.dispose();
		startButton.dispose();
		backGroundPicture.dispose();
	}
}
