package com.gp_group.albert.core.output.screens.letris_screen;

import com.badlogic.gdx.Gdx;
import com.gp_group.albert.helpers.MathHelpers;
import com.gp_group.albert.objects.Letter;
import com.gp_group.albert.objects.SelectedLetters;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * @author bluesialia
 *         Date: 11/02/15
 */
public class LetrisWorld {

    private final List<Letter>[] letters;
    private SelectedLetters selectedLetters;

    private final float worldWidth, worldHeight, lettersSize, gravity, maxSpeed;
    private final Random generator = new Random(System.currentTimeMillis());
    private float timer, period;

    /**
     * Creates a LetrisWorld instance.
     *
     * @param width
     * @param height
     * @param period time in seconds between the creations of letters.
     */
    public LetrisWorld(float width, float height, float period, float gravity, float maxSpeed) {
        Gdx.app.log("LetrisWorld", "created");
        this.worldWidth = width;
        this.worldHeight = height;
        this.period = period;
        this.gravity = gravity;
        this.maxSpeed = maxSpeed;
        this.lettersSize = calculateSizeOfLetters();
        this.selectedLetters = new SelectedLetters();
        this.letters = (List<Letter>[]) new List<?>[(int) (worldWidth / lettersSize)]; //FIXME: Unchecked cast
        for (int i = 0; i < this.letters.length; i++) {
            this.letters[i] = new LinkedList<Letter>();
        }
    }
    public List<Letter>[] getLetters(){
        return letters;
    }
    public SelectedLetters getSelectedLetters(){
        return selectedLetters;
    }


    /**
     * Calculates the size of the letters in a way the number of letters that fit in the screen isn't very small (<50) nor big (>110).
     */
    private float calculateSizeOfLetters() {
        int width = Math.round(worldWidth * 100) * 100,
                height = Math.round(worldHeight * 100) * 100;

        float size = (float) (MathHelpers.GCD(width, height)) / 10000f;

        while ((worldWidth / size) * (worldHeight / size) < 50) {
            size = size / 2;
        }
        while ((worldWidth / size) * (worldHeight / size) > 110) {
            size = size * 2; //NOTE: This needs to pass a series of tests to be sure it works. Because I think it shouldn't be executed... EVER.
        }

        return size;
    }

    /**
     * Calls the update() method of every element within the world.
     *
     * @param delta
     */
    public void update(float delta) {
        Gdx.app.log("LetrisWorld", "updated");
        timer += delta;
        if (timer > period) {
            timer -= period;
            createLetter();
        }

        for (List<Letter> list : letters) {
            for (Letter l : list) {
                l.update(delta, list, worldHeight);
            }
        }
    }

    /**
     * Creates a Letter in one of the columns (randomly chosen) and adds it to the respective list of letters.
     */
    public void createLetter() {
        Gdx.app.log("LetrisWorld", "letter created");
        int column = generator.nextInt(letters.length);
        Letter newLetter = new Letter(lettersSize, column * lettersSize, 0, gravity, maxSpeed);
        letters[column].add(newLetter);
    }
}
