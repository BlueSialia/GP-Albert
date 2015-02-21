package com.gp_group.albert;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.gp_group.albert.core.output.screens.fillthegaps_screen.FTGScreen;
import com.gp_group.albert.core.output.screens.letris_screen.LetrisScreen;
import com.gp_group.albert.core.output.screens.main_splash.MainSplash;
import com.gp_group.albert.core.output.screens.main_sreen.MainScreen;
import com.gp_group.albert.core.output.screens.multiplayer_screen.MultiplayerScreen;


/**
 * @author bluesialia
 *         Date: 4/02/15
 */
public class AlbertGame extends Game {
    final Screen splash = new MainSplash();
    final Screen main = new MainScreen();
    final Screen letris = new LetrisScreen();
    final Screen fillthegaps = new FTGScreen();
    final Screen multiplayer = new MultiplayerScreen();

    @Override
    public void create() {
        Gdx.app.log("AlbertGame", "created");
        setMainSplash();
    }

    public void setMainSplash() {
        Gdx.app.log("AlbertGame", "main splash active");
        setScreen(splash);
    }

    public void setMainScreen() {
        Gdx.app.log("AlbertGame", "main screen active");
        setScreen(main);
    }

    public void setLetrisScreen() {
        Gdx.app.log("AlbertGame", "letris screen active");
        setScreen(letris);
    }

    public void setFillTheGapsScreen() {
        Gdx.app.log("AlbertGame", "fillthegaps screen active");
        setScreen(fillthegaps);
    }
    public void setMultiplayerScreen(){
        Gdx.app.log("AlbertGame", "multiplayer screen active");
        setScreen(multiplayer);
    }
}
