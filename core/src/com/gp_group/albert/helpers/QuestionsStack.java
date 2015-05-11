package com.gp_group.albert.helpers;

import com.badlogic.gdx.Gdx;
import com.gp_group.albert.objects.Question;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 * Created by ac4r_g0 on 07/05/2015.
 */
public class QuestionsStack {
    private int QUESTION_NUMBER_PER_GAME = 9;
    private static QuestionsStack mQuestionsStack = new QuestionsStack();
    private ArrayList<Question> lQuestions;
    private int[] questions; //choose probabilistically
    private boolean[] memo;
    private static int numQuestion;

    private QuestionsStack() {

        this.lQuestions = new ArrayList<Question>();
        this.questions = new int[QUESTION_NUMBER_PER_GAME];
        this.memo = new boolean[QUESTION_NUMBER_PER_GAME];
        this.numQuestion = 0;
    }

    public static QuestionsStack getQuestionsStack (){
        return mQuestionsStack;
    }

    public void addQuestion(Question pQ) {
        this.lQuestions.add(pQ);
    }

    public Question loadQuestion(){
            if (numQuestion < questions.length) {
                return lQuestions.get(questions[numQuestion++]);
            }else{
                numQuestion = 0;
            }
        return null;
    }

    public void chooseQuestions(){
        ArrayList<Integer> list = new ArrayList<Integer>(lQuestions.size());
        for(int i = 0; i < lQuestions.size(); i++){
            list.add(i);
        }
        Collections.shuffle(list);

        for (int i = 0; i < QUESTION_NUMBER_PER_GAME; i++) {
             this.questions[i] = list.get(i);
        }
    }

}
