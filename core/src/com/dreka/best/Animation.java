package com.dreka.best;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

public class Animation {

    private Array<TextureRegion> frames;
    private int frameIndex;
    private int frameCount;
    private int backward;
    private int step;

    private float currentFrameTime;
    private float maxFrameTime;

    public Animation(TextureRegion bitmap, int frameCount, int backward) {

        frames = new Array<>();
        int frameWidth = bitmap.getRegionWidth() / frameCount;
        this.frameCount = frameCount;
        for(int i = 0; i < frameCount; i++){
            frames.add(new TextureRegion(bitmap, i * frameWidth, 0, frameWidth, bitmap.getRegionHeight()));

        }

        frameIndex = 0;
        this.backward = backward;
        step = 1;

        currentFrameTime = 0;
        float cycleTime = 1.0f;
        maxFrameTime = cycleTime / frameCount;
        System.out.println(maxFrameTime);
    }

    public void update(float delta){

        currentFrameTime += delta;
        if(currentFrameTime < maxFrameTime) return;
        currentFrameTime = 0;
        frameIndex += step;
        if(frameIndex >= frameCount){
            step *= backward;
            frameIndex += step;
        }

        if(frameIndex <= 0){
            step *= backward;
            frameIndex += step;
        }
    }

    public TextureRegion getFrame(){
        return frames.get(frameIndex);
    }
}
