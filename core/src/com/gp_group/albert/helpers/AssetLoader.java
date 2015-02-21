package com.gp_group.albert.core.output.screens.fillthegaps_helpers;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by ander on 18/02/15.
 * email: ancalotoru@gmail.com
 */
public class AssetLoader {

    public static Texture texture; //General texture for all the proyect
    public static TextureRegion background;
    public static TextureRegion optTexture;

    public static void load(){
        //TODO necesitamos los pixels para hacer este apartado.
    }

    public static void dispose(){
        texture.dispose();
    }
}
