package com.gp_group.albert.core.output.screens.fillthegaps_game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.gp_group.albert.core.output.screens.fillthegaps_helpers.AssetLoader;
import com.gp_group.albert.core.output.screens.fillthegaps_screen.FTGScreen;

/**
 * Created by ander on 18/02/15.
 * email: ancalotoru@gmail.com
 */
public class FillTheGaps extends Game {

    @Override
    public void create() {
        Gdx.app.log("FillTheGaps", "create");
        AssetLoader.load();
        setScreen(new FTGScreen());
    }

    public void dispose(){
        super.dispose();
        AssetLoader.dispose();
    }
}
