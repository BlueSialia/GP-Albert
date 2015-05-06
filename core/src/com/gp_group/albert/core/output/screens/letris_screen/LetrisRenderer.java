package com.gp_group.albert.core.output.screens.letris_screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.gp_group.albert.helpers.AssetLoader;
import com.gp_group.albert.objects.Letter;

import java.util.List;


public class LetrisRenderer {
    private LetrisWorld myLetrisWorld;
    private OrthographicCamera cam;
    private ShapeRenderer shapeRenderer;
    private int gameHeight, gameWidth;
    private SpriteBatch batcher;
    float runtime=0;

    public LetrisRenderer(LetrisWorld world, int gameWidth, int gameHeight){
        this.myLetrisWorld = world;
        this.gameHeight=gameHeight;
        this.gameWidth=gameWidth;

        cam = new OrthographicCamera();
        cam.setToOrtho(true, 136, this.gameHeight);
        batcher = new SpriteBatch();
        batcher.setProjectionMatrix(cam.combined);
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        // Call helper methods to initialize instance variables
        initGameObjects();
        initAssets();
    }

    public void render(float delta){
        Gdx.app.log("LetrisRenderer", "render");
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        runtime+=delta;

        // Begin ShapeRenderer
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        // Draw Background color
        shapeRenderer.setColor(Color.valueOf("ff8000"));
        shapeRenderer.rect(0, 0, 136, (gameHeight / 2) + 66);

        // Draw Grass
        shapeRenderer.setColor(Color.valueOf("ffaa55"));
        shapeRenderer.rect(0, (gameHeight/2) + 66, 136, 11);

        // Draw Dirt
        shapeRenderer.setColor(Color.valueOf("ffc68d"));
        shapeRenderer.rect(0, (gameHeight/2) + 77, 136, 52);

        // End ShapeRenderer
        shapeRenderer.end();

        // Begin SpriteBatch
        batcher.begin();
        // Disable transparency
        // This is good for performance when drawing images that do not require
        // transparency.
        batcher.enableBlending();

        List<Letter>[] letters = myLetrisWorld.getLetters();
        for (List<Letter> list : letters) {
            for (Letter l : list) {
                batcher.draw(AssetLoader.letrisOk, l.getBoundingRectangle().getX(), l.getBoundingRectangle().getY(), l.getBoundingRectangle().getWidth(), l.getBoundingRectangle().getHeight());
            }
        }

        // End SpriteBatch
        batcher.end();
    }

    private void initGameObjects() {
//        bird = myWorld.getBird();
//        scroller = myWorld.getScroller();
//        frontGrass = scroller.getFrontGrass();
//        backGrass = scroller.getBackGrass();
//        pipe1 = scroller.getPipe1();
//        pipe2 = scroller.getPipe2();
//        pipe3 = scroller.getPipe3();
    }

    private void initAssets() {
//        bg = AssetLoader.bg;
//        grass = AssetLoader.grass;
//        birdAnimation = AssetLoader.birdAnimation;
//        birdMid = AssetLoader.bird;
//        birdDown = AssetLoader.birdDown;
//        birdUp = AssetLoader.birdUp;
//        skullUp = AssetLoader.skullUp;
//        skullDown = AssetLoader.skullDown;
//        bar = AssetLoader.bar;
    }

    private void drawGrass() {
        // Draw the grass
//        batcher.draw(grass, frontGrass.getX(), frontGrass.getY(),
//                frontGrass.getWidth(), frontGrass.getHeight());
//        batcher.draw(grass, backGrass.getX(), backGrass.getY(),
//                backGrass.getWidth(), backGrass.getHeight());
    }
}
