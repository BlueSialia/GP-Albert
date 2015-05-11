package com.gp_group.albert.core.output.screens.letris_screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.gp_group.albert.helpers.AssetLoader;
import com.gp_group.albert.objects.Letter;

import java.util.List;


class LetrisRenderer {
    private final LetrisWorld myLetrisWorld;
    private final OrthographicCamera cam;
    private final ShapeRenderer shapeRenderer;
    private final float gameHeight;
    private final float gameWidth;
    private final SpriteBatch batcher;
    private final Stage stage;
    private float runtime = 0;

    public LetrisRenderer(LetrisWorld world, float gameWidth, float gameHeight){
        this.myLetrisWorld = world;
        this.gameHeight=gameHeight;
        this.gameWidth=gameWidth;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, gameWidth, this.gameHeight);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);
        stage = new Stage();
    }

    public void render(float delta){
        //Gdx.app.log("LetrisRenderer", "render");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        runtime+=delta;

        // Begin ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw Background
        shapeRenderer.setColor(Color.valueOf("ffaa55"));
        //shapeRenderer.rect(0, 0, 136, (gameHeight / 2) + 66);
        shapeRenderer.rect(0, 0, gameWidth, gameHeight);
        // Draw Header
        shapeRenderer.setColor(Color.valueOf("ff8000"));
        shapeRenderer.rect(0, 0, gameWidth, gameHeight * 0.10f);

        // Draw Container
        shapeRenderer.setColor(Color.valueOf("ffc68d"));
        shapeRenderer.rect(gameWidth*0.07f, gameHeight*0.12f, gameWidth*0.86f, gameHeight*0.75f);

        // End ShapeRenderer
        shapeRenderer.end();

        // Begin SpriteBatch
        batcher.begin();
        // Disable transparency
        // This is good for performance when drawing images that do not require
        // transparency.
        batcher.enableBlending();

        batcher.draw(AssetLoader.getLetrisOk(), gameWidth-gameWidth/5,gameHeight-gameHeight*0.10f,gameWidth/7,gameWidth/7);
        // End SpriteBatch
        batcher.end();
        borrarLetras();

        List<Letter>[] letters = myLetrisWorld.getLetters();
        for (List<Letter> list : letters) {
            for (Letter l : list) {
                if(list.size()>(int)(gameHeight-gameHeight*0.12f)/l.getBoundingRectangle().getHeight()) myLetrisWorld.gameOver();
                if(l.isSelected()) l.getBoton().setColor(Color.GREEN);
                else l.getBoton().setColor(Color.BLACK);
                if(!stage.getActors().contains(l.getBoton(), true)) stage.addActor(l.getBoton());
                //stage.addActor(l.getBoton());
            }
        }
        stage.addActor(myLetrisWorld.getPalabra());
        stage.draw();

    }

    void borrarLetras() {
        stage.clear();
    }
}
