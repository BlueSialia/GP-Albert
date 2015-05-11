package com.gp_group.albert.helpers;


import com.badlogic.gdx.Gdx;
import com.gp_group.albert.objects.Question;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

/**
 * Created by ac4r_g0 on 07/05/2015.
 */
public class XMLParser extends DefaultHandler{

        private static XMLParser mXMLParser = new XMLParser();
        private String text = "";
        private String phrase = null;
        private String[] answers = null;
        private String correct = null;
        private Question questionActual = null;

        private XMLParser() {}

        public static XMLParser getXMLParser() {
            return mXMLParser;
        }



        public void parseXmlFile(String pFilename) {
            // Utiliza el patrón Factory para obtener la instancia de parser
            SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
            try {
                SAXParser saxParser = saxParserFactory.newSAXParser();
			/*
			 * Procesa el fichero XML. Le pasamos la instancia
			 * que procesa las etiquetas, documento, etc.
			 * Tiene que proporcionar los métodos que se implementan
			 * debajo
			 */
//                saxParser.parse(new FileInputStream(pFilename), this);
                String resultado = "";
                BufferedReader in = new BufferedReader(new InputStreamReader(Gdx.files.internal("questions_ftg.xml").read()));
                String inputLine;
                while ((inputLine = in.readLine()) != null) {
//                    Gdx.app.log("asdfsdfadf", inputLine);
                    resultado = inputLine;
                }
                in.close();

                saxParser.parse(inputLine, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public void characters(char[] pCh, int pStart, int pLength)
                throws SAXException {
            this.text = new String(pCh,pStart,pLength);
        }

        public void endDocument() throws SAXException {

        }

        public void endElement(String pUri, String pLocalName, String pName)
                throws SAXException {
            if (pName.equalsIgnoreCase("phrase")){
                Gdx.app.log("Phrase", text);
                this.phrase = text;
            }else if (pName.equalsIgnoreCase("a1")){
                Gdx.app.log("a1", text);
                this.answers[0] = text;
            }else if (pName.equalsIgnoreCase("a2")){
                Gdx.app.log("a2", text);
                this.answers[1] = text;
            }else if (pName.equalsIgnoreCase("a3")){
                Gdx.app.log("a3", text);
                this.answers[2] = text;
            }else if (pName.equalsIgnoreCase("a4")){
                Gdx.app.log("a4", text);
                this.answers[3] = text;
            }else if(pName.equalsIgnoreCase("correctAnswer")){
                Gdx.app.log("correctAnswer", text);
                this.correct = text;
            }else if (pName.equalsIgnoreCase("question")) {
                Gdx.app.log("question", "cierre");
                QuestionsStack.getQuestionsStack().addQuestion(new Question(this.phrase, this.answers, this.correct));
            }
            //flush
            this.text = "";
        }

        public void startDocument() throws SAXException {

        }

        public void startElement(String pUri, String pLocalName, String pName,
                                 Attributes pAttributes) throws SAXException {
            if (pName.equalsIgnoreCase("phrase")){
                text="";
            }else if(pName.equalsIgnoreCase("posAnswers"))
                this.answers = new String[4];
        }

    }
