package com.gp_group.albert;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.gp_group.albert.core.output.screens.fillthegaps_screen.FTGScreen;
import com.gp_group.albert.core.output.screens.letris_screen.LetrisScreen;
import com.gp_group.albert.core.output.screens.main_splash.MainSplash;
import com.gp_group.albert.core.output.screens.main_sreen.MainScreen;
import com.gp_group.albert.helpers.AssetLoader;


/**
 * @author bluesialia
 *         Date: 4/02/15
 */
public class AlbertGame extends Game {

    private Screen splash;
    private Screen main;
    private Screen letris;
    private Screen fillthegaps;
    private Screen multiplayer;

    /**
     * Starts the app.
     */
    @Override
    public void create() {
        Gdx.app.log("AlbertGame", "created");
        AssetLoader.load();
        splash = new MainSplash(this);
        setMainSplash();
    }

    /**
     * Sets the SplashScreen as active.
     */
    void setMainSplash() {
        Gdx.app.log("AlbertGame", "main splash active");
        setScreen(splash);
    }

    /**
     * Sets the MainScreen as active.
     */
    public void setMainScreen() {
        Gdx.app.log("AlbertGame", "main screen active");
        main = new MainScreen(this);
        setScreen(main);
    }

    /**
     * Sets the LetrisScreen as active.
     */
    public void setLetrisScreen() {
        Gdx.app.log("AlbertGame", "letris screen active");
        letris = new LetrisScreen(this);
        setScreen(letris);
    }

    /**
     * Sets the FillTheGapsScreen as active.
     */
    public void setFillTheGapsScreen() {
        Gdx.app.log("AlbertGame", "fillthegaps screen active");
        fillthegaps = new FTGScreen(this);
        setScreen(fillthegaps);
    }

    /**
     * Sets the MultiplayerScreen as active.
     */
    public void setMultiplayerScreen() {
        Gdx.app.log("AlbertGame", "multiplayer screen active");
        setScreen(multiplayer);
    }
}
