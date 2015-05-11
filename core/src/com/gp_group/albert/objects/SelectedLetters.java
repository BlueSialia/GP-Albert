package com.gp_group.albert.objects;

import java.util.ArrayList;
import java.util.Iterator;

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

    public String getPalabra(){
        Iterator<Letter> itr = lettersSelected.iterator();
        String palabra="";
        while(itr.hasNext()){
            palabra= palabra + itr.next().getLetra();
        }
        return palabra;
    }

    public Iterator<Letter> getIterador(){
        return lettersSelected.iterator();
    }
}
