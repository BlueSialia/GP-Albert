package com.gp_group.albert.core.output.screens.letris_screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * @author bluesialia
 *         Date: 4/02/15
 */
public class LetrisScreen implements Screen {

    private final LetrisWorld world;
    private float runtime;

    /**
     * Creates a LetrisScreen instance.
     */
    public LetrisScreen() {
        Gdx.app.log("LetrisScreen", "created");
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        this.world = new LetrisWorld(screenWidth, screenHeight, 5, 5, 5);//FIXME: reduce dimension for the rest of UI (buttons...), because the size of the world is not the full screen. And find the correct period, gravity and maxSpeed.
    }

    /**
     * Called when this screen becomes the current screen for a {@link com.badlogic.gdx.Game}.
     */
    @Override
    public void show() {
        Gdx.app.log("LetrisScreen", "shown");
    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {
        Gdx.app.log("LetrisScreen", "rendered");
        runtime += delta;
        world.update(delta);
    }

    /**
     * @param width
     * @param height
     * @see com.badlogic.gdx.ApplicationListener#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {
        Gdx.app.log("LetrisScreen", "resized");
    }

    /**
     * @see com.badlogic.gdx.ApplicationListener#pause()
     */
    @Override
    public void pause() {
        Gdx.app.log("LetrisScreen", "paused");
    }

    /**
     * @see com.badlogic.gdx.ApplicationListener#resume()
     */
    @Override
    public void resume() {
        Gdx.app.log("LetrisScreen", "resumed");
    }

    /**
     * Called when this screen is no longer the current screen for a {@link com.badlogic.gdx.Game}.
     */
    @Override
    public void hide() {
        Gdx.app.log("LetrisScreen", "hided");
    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {
        Gdx.app.log("LetrisScreen", "disposed");
    }
}
