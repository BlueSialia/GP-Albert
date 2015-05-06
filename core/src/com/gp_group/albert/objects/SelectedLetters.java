package com.gp_group.albert.objects;

import java.util.ArrayList;

public class SelectedLetters {
    private final ArrayList<Letter> lettersSelected;

    public SelectedLetters() {
        this.lettersSelected = new ArrayList<Letter>();
    }


    public boolean addSelectedLetter(Letter letter) {
        lettersSelected.add(letter);
        return true;
    }

    public boolean removeSelectedLetter(Letter letter) {
        if (lettersSelected.contains(letter)) {
            lettersSelected.remove(letter);
            return true;
        }
        return false;
    }

    public boolean reiniciar() {
        lettersSelected.clear();
        return true;
    }
}
