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
    private static TextureRegion background;
    private static Dictionary _dictionary_;

    public static void load() throws IOException {
        //TODO necesitamos los pixels para hacer este apartado.
        texture = new Texture(Gdx.files.internal("android/assets/textureAlbert.png"));
        texture.setFilter(Texture.TextureFilter.Nearest, Texture.TextureFilter.Nearest);

        background = new TextureRegion(texture, 0, 0, 136, 43);
        background.flip(false, true);
    }

    public static void dispose() {
        texture.dispose();
    }

    public static Dictionary loadDictionary(String language) throws IOException {
        _dictionary_ = new Dictionary(Gdx.files.internal("dictionary/" + language + ".dic"));
        return _dictionary_;
    }
}
