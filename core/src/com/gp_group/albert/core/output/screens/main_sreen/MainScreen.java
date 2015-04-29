package com.gp_group.albert.core.output.screens.main_sreen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * @author bluesialia
 *         Date: 10/02/15
 */
public class MainScreen implements Screen {

    private float runtime;
    private MainWorld gw;
    private MainRenderer gr;

    /**
     * Creates a MainScreen instance.
     */
    public MainScreen() {
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();

    }

    /**
     * Called when this screen becomes the current screen for a {@link com.badlogic.gdx.Game}.
     */
    @Override
    public void show() {
        Gdx.app.log("MainScreen", "shown");
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
    }

    /**
     * Called when this screen is no longer the current screen for a {@link com.badlogic.gdx.Game}.
     */
    @Override
    public void hide() {
        Gdx.app.log("MainScreen", "hided");
    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {
        Gdx.app.log("MainScreen", "disposed");
    }
}
