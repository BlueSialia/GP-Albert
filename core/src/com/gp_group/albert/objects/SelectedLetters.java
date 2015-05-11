package com.gp_group.albert.objects;

import java.util.ArrayList;
import java.util.Iterator;

public class SelectedLetters {
    private final ArrayList<Letter> lettersSelected;

    public SelectedLetters() {
        this.lettersSelected = new ArrayList<Letter>();
    }


    public boolean addSelectedLetter(Letter letter) {
        return lettersSelected.add(letter);
    }

    public boolean removeSelectedLetter(Letter letter) {
        return lettersSelected.contains(letter) && lettersSelected.remove(letter);
    }

    public void reiniciar() {
        lettersSelected.clear();
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
