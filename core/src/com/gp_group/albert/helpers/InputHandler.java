package com.gp_group.albert.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Rectangle;
import com.gp_group.albert.core.output.screens.letris_screen.LetrisWorld;
import com.gp_group.albert.objects.Letter;

import java.util.Iterator;
import java.util.List;

public class InputHandler implements InputProcessor {
    private final LetrisWorld world;
    private final float gameWidth = Gdx.graphics.getWidth();
    private final float gameHeight = Gdx.graphics.getHeight();
    private final Rectangle botonOk;

    public InputHandler(LetrisWorld world) {
        this.world = world;
        botonOk = new Rectangle(gameWidth-gameWidth/5,gameHeight-gameHeight*0.10f,gameWidth/7,gameWidth/7);
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
        if(botonOk.contains(screenX,screenY)){
            Gdx.app.log("InputHandler", world.getPalabra().getText());
            if(AssetLoader.getDiccionario().exist(world.getPalabra().getText())){
                //TODO sumar puntuacion
                Iterator<Letter> itr = world.getSelectedLetters().getIterador();
                while(itr.hasNext()){
                    Letter letra=itr.next();
                    for(int i=0; i<world.getLetters().length;i++){
                        if(world.getLetters()[i].contains(letra))
                        world.getLetters()[i].remove(letra);
                    }
                }
                world.getSelectedLetters().reiniciar();
            }
        }
        for (List<Letter> list : world.getLetters()) {
            for (Letter l : list) {
                l.isTouchDown(screenX-gameWidth*0.07f, gameHeight-screenY);
            }
        }
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        for (List<Letter> list : world.getLetters()) {
            for (Letter l : list) {
                l.isTouchUp(screenX-gameWidth*0.07f, gameHeight-screenY, world);
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
