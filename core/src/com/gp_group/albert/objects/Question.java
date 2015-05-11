package com.gp_group.albert.objects;

/**
 * Created by ander on 18/02/15.
 * email: ancalotoru@gmail.com
 */
public class Question {

    private final String phrase;
    private final String[] possibleAnswers;
    private final String correctAnswer;

    public Question(String pPhrase, String[] pAnswers, String correctAnswer){
        this.phrase = pPhrase;
        possibleAnswers = new String[4];
        int i = 0;
        for (String a : pAnswers) {
            possibleAnswers[i] = a;
            i++;
        }
        this.correctAnswer = correctAnswer;
    }

    public String getPhrase() {
        return this.phrase;
    }

    public boolean checkAnswer(String pPossible){
        return this.correctAnswer.equals(pPossible);
    }

    public String[] getPossibleAnswers() {
        return possibleAnswers;
    }
}
