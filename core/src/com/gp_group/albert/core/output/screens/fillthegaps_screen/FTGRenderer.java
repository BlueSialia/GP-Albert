package com.gp_group.albert.core.output.screens.fillthegaps_screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.gp_group.albert.objects.Question;

/**
 * Created by ander on 18/02/15.
 * email: ancalotoru@gmail.com
 */
class FTGRenderer {
    private final FTGWorld myFtgWorld;
    private final OrthographicCamera cam;
    private final ShapeRenderer shapeRenderer;
    //    private SpriteBatch batch;
//    private BitmapFont font;
    private final float gameHeight;
    private final float gameWidth;
    private final Stage stage;
    private Question question;
    private TextArea taPhrase;
    private TextButton btnAnswer1;
    private TextButton btnAnswer2;
    private TextButton btnAnswer3;
    private TextButton btnAnswer4;
    private TextButton btnMenu;
    private TextButton btnScore;
    private TextButton btnRetry;
    private ProgressBar timeBar;

    public FTGRenderer(FTGWorld world, float gameWidth, float gameHeight){
        this.myFtgWorld = world;
        this.gameHeight = gameHeight;
        this.gameWidth = gameWidth;
        cam = new OrthographicCamera();
        cam.setToOrtho(true, gameWidth, gameHeight);

        this.initGameObjects();

        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(cam.combined);

        stage = new Stage();
        stage.addActor(taPhrase);
        Gdx.input.setInputProcessor(stage);

        stage.addActor(btnAnswer1);
        stage.addActor(btnAnswer2);
        stage.addActor(btnAnswer3);
        stage.addActor(btnAnswer4);
        stage.addActor(btnMenu);
        stage.addActor(btnScore);
        stage.addActor(btnRetry);
        stage.addActor(timeBar);
    }

    public void render(){
//        Gdx.app.log("FTGRenderer", "render");
//        Gdx.gl.glClearColor(0, 0, 0, 1);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);

        shapeRenderer.setColor(Color.valueOf("FFEAB0")); //background
        shapeRenderer.rect(0,0,gameWidth, gameHeight);

        shapeRenderer.setColor(Color.valueOf("FFBB33")); //head background
        shapeRenderer.rect(0,0,gameWidth, gameHeight/10);

        shapeRenderer.end();

        stage.draw();
        myFtgWorld.getBatch().begin();
        myFtgWorld.getYourBitmapFontName().setColor(1.0f, 0.255f, 0.212f, 1.0f);
//        myFtgWorld.getYourBitmapFontName().draw(myFtgWorld.getBatch(), myFtgWorld.getYourScoreName(), 293, 80);
        myFtgWorld.getYourBitmapFontName().draw(myFtgWorld.getBatch(), myFtgWorld.getYourScoreName(), gameWidth - gameWidth/2 - gameWidth/17, gameHeight/6);
        myFtgWorld.getBatch().end();
    }


    private void initGameObjects(){
        this.taPhrase = myFtgWorld.getTaPhrase();
        btnAnswer1 = myFtgWorld.getBtnAnswer1();
        btnAnswer2 = myFtgWorld.getBtnAnswer2();
        btnAnswer3 = myFtgWorld.getBtnAnswer3();
        btnAnswer4 = myFtgWorld.getBtnAnswer4();
        btnMenu = myFtgWorld.getBtnMenu();
        btnScore = myFtgWorld.getBtnScore();
        btnRetry = myFtgWorld.getBtnRetry();
        timeBar = myFtgWorld.getTimeBar();
    }
}
