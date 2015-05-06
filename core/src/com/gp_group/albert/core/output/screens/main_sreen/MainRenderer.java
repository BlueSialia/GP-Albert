package com.gp_group.albert.core.output.screens.main_sreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

/**
 * Created by Duque on 29/04/2015.
 */
public class MainRenderer {
    private MainWorld myMainWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;

    public MainRenderer(MainWorld world) {
        this.myMainWorld = world;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, 204);

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
    }

    public void render() {
        Gdx.app.log("MainRenderer", "render");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
    }
}
