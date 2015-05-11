package com.gp_group.albert.helpers;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.utils.XmlReader;
import com.gp_group.albert.objects.Question;

import java.io.IOException;
import java.util.Iterator;

/**
 * Created by ac4r_g0 on 11/05/2015.
 */
public class ParserLibGDX {

    private static ParserLibGDX mParserLibGDX = new ParserLibGDX();
    private String phrase = null;
    private String[] answers = null;
    private String correct = null;

    private ParserLibGDX(){

    }

    public static ParserLibGDX getParserLibGDX(){
        return mParserLibGDX;
    }
    public void parseFile(){
        XmlReader xml = new XmlReader();
        XmlReader.Element xml_element = null;
        try {
            xml_element = xml.parse(Gdx.files.internal("questions_ftg.xml"));
            Iterator iterator_question = xml_element.getChildrenByName("question").iterator();
            while(iterator_question.hasNext()){
                XmlReader.Element question_element = (XmlReader.Element) iterator_question.next();
                phrase = question_element.get("phrase");
//                Iterator iterator_posAnswers = xml_element.getChildrenByName("posAnswers").iterator();
                this.answers = new String[4];
//                int i = 0;
//                while(iterator_posAnswers.hasNext()) {
//                    XmlReader.Element answer_element = (XmlReader.Element) iterator_posAnswers.next();
//                    this.answers[i] = answer_element.get("a"+(i+1));
//                    i++;
//                }
                this.answers[0] = question_element.getChildrenByName("posAnswers").get(0).get("a1");
                this.answers[1] = question_element.getChildrenByName("posAnswers").get(0).get("a2");
                this.answers[2] = question_element.getChildrenByName("posAnswers").get(0).get("a3");
                this.answers[3] = question_element.getChildrenByName("posAnswers").get(0).get("a4");
                this.correct = question_element.get("correctAnswer");
                QuestionsStack.getQuestionsStack().addQuestion(new Question(this.phrase, this.answers, this.correct));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
