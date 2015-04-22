package com.gp_group.albert.helpers;

import com.badlogic.gdx.InputProcessor;
import com.gp_group.albert.core.output.screens.letris_screen.LetrisWorld;
import com.gp_group.albert.objects.Letter;

import java.util.List;

public class InputHandler implements InputProcessor{
    private LetrisWorld world;

    public InputHandler(LetrisWorld world) {
        this.world = world;
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
        for (List<Letter> list : world.getLetters()) {
            for (Letter l : list) {
                l.isTouchDown(screenX, screenY);
            }
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for (List<Letter> list : world.getLetters()) {
            for (Letter l : list) {
                l.isTouchUp(screenX, screenY, world);
            }
        }
        return true;
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
