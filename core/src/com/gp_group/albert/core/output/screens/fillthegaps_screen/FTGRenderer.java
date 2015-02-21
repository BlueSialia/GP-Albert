package com.gp_group.albert.core.output.screens.fillthegaps_screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by ander on 18/02/15.
 * email: ancalotoru@gmail.com
 */
public class FTGRenderer {
    private FTGWorld myFtgWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    public FTGRenderer(FTGWorld world){
        this.myFtgWorld = world;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render(){
        Gdx.app.log("FTGRenderer", "render");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
