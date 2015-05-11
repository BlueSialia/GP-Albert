package com.gp_group.albert.helpers;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;

/**
 * Created by ander on 6/05/15.
 * email: ancalotoru@gmail.com
 */
public class FTGHandler implements InputProcessor {

    private TextField tfAnswer1;
    private TextField tfAnswer2;
    private TextField tfAnswer3;
    private TextField tfAnswer4;

    public FTGHandler(TextField tf1, TextField tf2, TextField tf3, TextField tf4){

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}
