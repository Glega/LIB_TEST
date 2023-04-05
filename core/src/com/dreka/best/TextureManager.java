package com.dreka.best;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.Disposable;

public class TextureManager {

    private Array<Disposable> textures;


    public TextureManager() {
        textures = new Array<>();
    }

    public Texture createTexture(String internalPath){
        Texture texture = new Texture(internalPath);
        textures.add(texture);
        return  texture;
    }

    public void dispose(){
        for(int i = 0; i < textures.size; i++){
            textures.get(i).dispose();
        }
    }
}
