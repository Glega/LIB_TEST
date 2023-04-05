package com.dreka.best;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
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

public class MainScreen extends Game {

	int screenWidth;
	int screenHeight;



	public MainScreen(int screenWidth, int screenHeight) {
		this.screenWidth = screenWidth;
		this.screenHeight = screenHeight;

	}

	@Override
	public void create () {
		System.out.println("Screen resolution: " + Gdx.graphics.getWidth() + "x" + Gdx.graphics.getHeight());
		setScreen(new MainMenu(this));
	}

	/*
	@Override
	public void render () {


		shapeRenderer.begin(ShapeRenderer.ShapeType.Line);
		shapeRenderer.setColor(0, 1, 0, 1);
		shapeRenderer.line(0,0, 100,100);
		shapeRenderer.end();


	}
	*/
	
	@Override
	public void dispose () {
		super.dispose();

	}
}
