package com.gp_group.albert.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.gp_group.albert.objects.Dictionary;

import java.io.IOException;

/**
 * Created by ander on 18/02/15.
 * email: ancalotoru@gmail.com
 */
public class AssetLoader {

    private static Texture texture; //General texture for all the proyect
    private static TextureRegion letrisOk;
    private static TextureRegion letrisBorrar;

    private static TextureRegion letrisAtras;
    private static Dictionary _dictionary_;

    public static void load(){
        //TODO necesitamos los pixels para hacer este apartado.

        texture = new Texture(Gdx.files.internal("textureAlbert.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        letrisOk = new TextureRegion(texture, 15, 15, 460, 460); //x, y, width, height
        letrisOk.flip(false, true);

        letrisBorrar = new TextureRegion(texture, 15, 515, 460, 460); //x, y, width, height
        letrisBorrar.flip(false, true);

        letrisAtras = new TextureRegion(texture, 35, 535, 350, 510); //x, y, width, height
        letrisAtras.flip(false, true);

        try {
            loadDictionary("en_UK");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void dispose(){
        texture.dispose();
    }

    public static void loadDictionary(String language) throws IOException {
        _dictionary_ = new Dictionary(Gdx.files.internal("dictionary/" + language + ".dic"));
    }

    public static Dictionary getDiccionario() {
        return _dictionary_;
    }

    public static TextureRegion getLetrisAtras() {
        return letrisAtras;
    }

    public static TextureRegion getLetrisBorrar() {
        return letrisBorrar;
    }

    public static TextureRegion getLetrisOk() {
        return letrisOk;
    }
}
