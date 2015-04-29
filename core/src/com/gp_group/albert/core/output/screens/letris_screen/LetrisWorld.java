package com.gp_group.albert.core.output.screens.letris_screen;

import com.badlogic.gdx.Gdx;
import com.gp_group.albert.helpers.MathHelpers;
import com.gp_group.albert.objects.Letter;
import com.gp_group.albert.objects.SelectedLetters;

import org.apache.commons.math3.fraction.Fraction;

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
    private final float period;
    private float timer;

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
        selectedLetters = new SelectedLetters();
        this.worldHeight = height;
        this.period = period;
        this.gravity = gravity;
        this.maxSpeed = maxSpeed;
        this.lettersSize = calculateSizeOfLetters();
        this.letters = (List<Letter>[]) new List<?>[(int) (worldWidth / lettersSize)]; //FIXME: Unchecked cast
        for (int i = 0; i < this.letters.length; i++) {
            this.letters[i] = new LinkedList<Letter>();
        }
    }

    /**
     * Calculates the size of the letters in a way the number of letters that fit in the screen isn't very small (<50) nor big (>150).
     */
    private float calculateSizeOfLetters() {
        Gdx.app.log("LetrisWorld", "calculated the Size Of Letters");
        Fraction fraction = MathHelpers.diophantineApproximation(worldHeight / worldWidth, 50, 150); //NOTE: I don't think this is going to work in the first try.
        return worldWidth / fraction.getDenominator();
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
    public SelectedLetters getSelectedLetters() {
        return this.selectedLetters;
    }
    public List<Letter>[] getLetters(){
        return this.letters;
    }
}
