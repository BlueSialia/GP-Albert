package com.gp_group.albert.helpers;

import com.gp_group.albert.objects.Question;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by ac4r_g0 on 07/05/2015.
 */
public class QuestionsStack {
    private static final QuestionsStack mQuestionsStack = new QuestionsStack();
    private static int numQuestion;
    private final int QUESTION_NUMBER_PER_GAME = 9;
    private final ArrayList<Question> lQuestions;
    private final int[] questions; //choose probabilistically
    private final boolean[] memo;

    private QuestionsStack() {

        this.lQuestions = new ArrayList<Question>();
        this.questions = new int[QUESTION_NUMBER_PER_GAME];
        this.memo = new boolean[QUESTION_NUMBER_PER_GAME];
        numQuestion = 0;
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
