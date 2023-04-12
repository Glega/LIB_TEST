package com.dreka.best;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class Animal implements Disposable {
    private Sprite sprite;
    private Array<TextureRegion> frames;
    private int frameIndex;
    private int frameCount;

    private float currentFrameTime;
    private float maxFrameTime;
    private Vector2 position;
    private Texture texture;

    public Animal(String internalPath, int rows, int frameCount) {

        texture = new Texture(internalPath);

        TextureRegion bitmap = new TextureRegion(texture);

        frames = new Array<>();
        int frameWidth = bitmap.getRegionWidth() / frameCount;
        int frameHeight = bitmap.getRegionHeight() / rows;
        this.frameCount = frameCount;
        for(int i = 0; i < frameCount; i++){
            frames.add(new TextureRegion(bitmap, i * frameWidth, frameHeight * 2, frameWidth, frameHeight));

        }
        frameIndex = 0;

        currentFrameTime = 0;
        float cycleTime = 0.3f;
        maxFrameTime = cycleTime / frameCount;

        sprite = new Sprite(frames.get(0));
        position = new Vector2(0,100);
    }

    public void update(float delta){

        currentFrameTime += delta;

        position.x += 200 * delta;
        if(position.x > 2130) position.x = -250;

        sprite.setPosition(position.x,position.y);

        if(currentFrameTime < maxFrameTime) return;
        currentFrameTime = 0;
        frameIndex += 1;
        if(frameIndex >= frameCount){
            frameIndex = 0;
        }


        sprite.setRegion(frames.get(frameIndex));
    }

    public void draw(SpriteBatch batch){
        sprite.draw(batch);
    }

    public Vector2 getPosition(){
        return this.position;
    }

    @Override
    public void dispose() {
        texture.dispose();
    }
}
