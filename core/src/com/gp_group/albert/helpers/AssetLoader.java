package com.gp_group.albert.helpers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by ander on 18/02/15.
 * email: ancalotoru@gmail.com
 */
public class AssetLoader {

    private static Texture texture; //General texture for all the proyect
    private static TextureRegion background;
    private static TextureRegion optTexture;

    public static void load(){
        //TODO necesitamos los pixels para hacer este apartado.
    }

    public static void dispose(){
        texture.dispose();
    }
}
