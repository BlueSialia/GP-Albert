package com.gp_group.albert.core.output.screens.main_sreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.gp_group.albert.AlbertGame;

/**
 * @author bluesialia
 *         Date: 10/02/15
 */
public class MainScreen implements Screen {

    private Stage stage;
    private Table table;
    private AlbertGame game;
    private Label title;
    private Skin skin;
    private TextButton buttonFill;
    private TextButton buttonLetris;
    private TextButton buttonDict;
    private int screenWidth;
    private int screenHeight;
    private float runtime;

    /**
     * Creates a MainScreen instance.
     */
    public MainScreen(AlbertGame game) {
        this.game = game;
        screenWidth = Gdx.graphics.getWidth();
        screenHeight = Gdx.graphics.getHeight();
        stage = new Stage();
        table = new Table();
        skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas(Gdx.files.internal("uiskin.atlas")));
        skin.getFont("default-font").setScale(3);
        buttonFill = new TextButton("Play FillTheGaps", skin);
        buttonLetris = new TextButton("Play Letris", skin);
        buttonDict = new TextButton("Select Language", skin);
        title = new Label("Albert", skin);
    }

    /**
     * Called when this screen becomes the current screen for {@link com.gp_group.albert.AlbertGame}.
     */
    @Override
    public void show() {
        Gdx.app.log("MainScreen", "shown");
        buttonFill.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setFillTheGapsScreen();
            }
        });
        buttonLetris.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setLetrisScreen();
            }
        });
        buttonDict.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //TODO
            }
        });

        table.add(title).padBottom(40).row();
        table.add(buttonFill).size(screenWidth / 3, screenWidth / 10).padBottom(screenWidth / 30).row();
        table.add(buttonLetris).size(screenWidth / 3, screenWidth / 10).padBottom(screenWidth / 30).row();
        table.add(buttonDict).size(screenWidth / 3, screenWidth / 10).padBottom(screenWidth / 30).row();

        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);
    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        Gdx.app.log("MainScreen", "rendered");
        runtime += delta;
        Gdx.gl.glClearColor(1, 0.5f, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act();
        stage.draw();
    }

    /**
     * @param width
     * @param height
     * @see com.badlogic.gdx.ApplicationListener#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
        Gdx.app.log("MainScreen", "resized");
    }

    /**
     * @see com.badlogic.gdx.ApplicationListener#pause()
     */
    @Override
    public void pause() {
        Gdx.app.log("MainScreen", "paused");
    }

    /**
     * @see com.badlogic.gdx.ApplicationListener#resume()
     */
    @Override
    public void resume() {
        Gdx.app.log("MainScreen", "resumed");
        stage = new Stage();
        table = new Table();
        skin = new Skin(Gdx.files.internal("uiskin.json"), new TextureAtlas(Gdx.files.internal("uiskin.atlas")));
        skin.getFont("default-font").setScale(3);
        buttonFill = new TextButton("Play FillTheGaps", skin);
        buttonLetris = new TextButton("Play Letris", skin);
        buttonDict = new TextButton("Select Language", skin);
        title = new Label("Albert", skin);

        buttonFill.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setFillTheGapsScreen();
            }
        });
        buttonLetris.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                game.setLetrisScreen();
            }
        });
        buttonDict.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //TODO
            }
        });

        table.add(title).padBottom(40).row();
        table.add(buttonFill).size(screenWidth / 3, screenWidth / 10).padBottom(screenWidth / 30).row();
        table.add(buttonLetris).size(screenWidth / 3, screenWidth / 10).padBottom(screenWidth / 30).row();
        table.add(buttonDict).size(screenWidth / 3, screenWidth / 10).padBottom(screenWidth / 30).row();

        table.setFillParent(true);
        stage.addActor(table);

        Gdx.input.setInputProcessor(stage);

    }

    /**
     * Called when this screen is no longer the current screen for {@link com.gp_group.albert.AlbertGame}.
     */
    @Override
    public void hide() {
        Gdx.app.log("MainScreen", "hided");
        stage.dispose();
        skin.dispose();
    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {
        Gdx.app.log("MainScreen", "disposed");
        stage.dispose();
        skin.dispose();
    }
}
