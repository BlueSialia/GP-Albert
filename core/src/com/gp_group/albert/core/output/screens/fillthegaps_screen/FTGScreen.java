package com.gp_group.albert.core.output.screens.fillthegaps_screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

/**
 * @author GPAlbert
 *         Date: 4/02/15
 */
public class FTGScreen implements Screen {

    private FTGWorld gw;
    private FTGRenderer gr;

    public FTGScreen(){
        float screenWidth = Gdx.graphics.getWidth();
        float screenHeight = Gdx.graphics.getHeight();
        float gameWidth = 136;
        float gameHeight = screenHeight/(screenWidth/gameWidth);
        int midPointY = (int) gameHeight/2;
        Gdx.app.log("FTGScreen", "attached");
        gw = new FTGWorld(midPointY);
        gr = new FTGRenderer(gw);
        // TODO
        //Gdx.input.setInputProcessor();
    }

    /**
     * Called when this screen becomes the current screen for a {@link com.badlogic.gdx.Game}.
     */
    @Override
    public void show() {

    }

    /**
     * Called when the screen should render itself.
     *
     * @param delta The time in seconds since the last render.
     */
    @Override
    public void render(float delta) {

    }

    /**
     * @param width
     * @param height
     * @see com.badlogic.gdx.ApplicationListener#resize(int, int)
     */
    @Override
    public void resize(int width, int height) {

    }

    /**
     * @see com.badlogic.gdx.ApplicationListener#pause()
     */
    @Override
    public void pause() {

    }

    /**
     * @see com.badlogic.gdx.ApplicationListener#resume()
     */
    @Override
    public void resume() {

    }

    /**
     * Called when this screen is no longer the current screen for a {@link com.badlogic.gdx.Game}.
     */
    @Override
    public void hide() {

    }

    /**
     * Called when this screen should release all resources.
     */
    @Override
    public void dispose() {

    }
}