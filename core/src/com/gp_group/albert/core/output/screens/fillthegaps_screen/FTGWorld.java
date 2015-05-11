package com.gp_group.albert.core.output.screens.fillthegaps_screen;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.NinePatch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.badlogic.gdx.scenes.scene2d.actions.DelayAction;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Timer;
import com.gp_group.albert.helpers.ParserLibGDX;
import com.gp_group.albert.helpers.QuestionsStack;
import com.gp_group.albert.helpers.XMLParser;
import com.gp_group.albert.objects.Question;

/**
 * Created by ander on 18/02/15.
 * email: ancalotoru@gmail.com
 */
public class FTGWorld {
    private Question question;
    private TextArea taPhrase;

//    private TextField tfAnswer1;
//    private TextField tfAnswer2;
//    private TextField tfAnswer3;
//    private TextField tfAnswer4;

    private TextButton btnAnswer1;
    private TextButton btnAnswer2;
    private TextButton btnAnswer3;
    private TextButton btnAnswer4;

//    private TextButton btnNext;

    private ProgressBar timeBar;

    private TextButton btnScore;
    private TextButton btnMenu;
    private TextButton btnRetry;

    private float screenWidth;
    private float screenHeight;
    //Helpers to Text*
    private Skin skinPhrase;

    private Skin skinRest;
    private Skin skinProgressBar;
    //TODO: private Option option;
    //TODO: private Score score;
    private long time_start;
    private int TIME_LIMIT = 20*1000;
    private boolean startQuestion;

    private Timer.Task timer;

    private long playTime;

    private boolean checkedAnswer;
    private boolean btn1touch;
    private boolean btn2touch;
    private boolean btn3touch;
    private boolean btn4touch;

    private boolean isCheckingAnswer;

    private int score = 0;
    private String yourScoreName;
    private SpriteBatch batch;
    private BitmapFont yourBitmapFontName;


    public FTGWorld(float pScreenWidth, float pScreenHeight){
//        XMLParser.getXMLParser().parseXmlFile("questions_ftg.xml");
        ParserLibGDX.getParserLibGDX().parseFile();
        QuestionsStack.getQuestionsStack().chooseQuestions();
        skinPhrase = new Skin(Gdx.files.internal("uiskinPhrase.json"));
        skinRest = new Skin(Gdx.files.internal("uiskin.json"));

        playTime = 0;

        skinProgressBar = new Skin();
        Pixmap pixmap = new Pixmap(10, 10, Pixmap.Format.RGBA8888);
        pixmap.setColor(Color.WHITE);
        pixmap.fill();
        skinProgressBar.add("white", new Texture(pixmap));

        taPhrase = new TextArea("", skinPhrase);


        //TODO mirar otro skin como el de kilobolt
        btnRetry = new TextButton("RETRY", skinRest);
        btnScore = new TextButton("", skinRest);
        btnMenu = new TextButton("MENU",skinRest);
        btnAnswer1 = new TextButton("", skinRest);
        btnAnswer2 = new TextButton("", skinRest);
        btnAnswer3 = new TextButton("", skinRest);
        btnAnswer4 = new TextButton("", skinRest);

        TextureRegionDrawable textureBar = new TextureRegionDrawable(new TextureRegion(new Texture(Gdx.files.internal("progress.png"))));
        ProgressBar.ProgressBarStyle progrsbarStyle = new ProgressBar.ProgressBarStyle(skinProgressBar.newDrawable("white", Color.LIGHT_GRAY), textureBar);

        progrsbarStyle.knobBefore = progrsbarStyle.knob;
        timeBar = new ProgressBar(0.0f, (float) TIME_LIMIT, 1.0f, false, progrsbarStyle);

        this.screenWidth = pScreenWidth;
        this.screenHeight = pScreenHeight;

        buildTimer();

        yourScoreName = "Score: 0";
        yourBitmapFontName = new BitmapFont();
        batch = new SpriteBatch();

        btnScore.setVisible(false);
        btnScore.setTouchable(Touchable.disabled);
        btnRetry.setVisible(false);

        btnAnswer1.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!question.checkAnswer(String.valueOf(btnAnswer1.getText()))) {
                    timeBar.setVisible(false);
                    btnAnswer1.setColor(Color.RED);
                    time_start = System.currentTimeMillis();
                    checkedAnswer = true;
                    score -= 100;
                    yourScoreName = "Score: " + score;
                } else {
                    timeBar.setVisible(false);
                    btnAnswer1.setColor(Color.GREEN);
                    time_start = System.currentTimeMillis();
                    checkedAnswer = true;
                    score += 100;
                    yourScoreName = "Score: " + score;
                }
            }
        });

        btnAnswer2.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(!question.checkAnswer(String.valueOf(btnAnswer2.getText()))){
                    timeBar.setVisible(false);
                    btnAnswer2.setColor(Color.RED);
                    time_start = System.currentTimeMillis();
                    checkedAnswer = true;
                    score -= 100;
                    yourScoreName = "Score: " + score;
                }else{
                    timeBar.setVisible(false);
                    btnAnswer2.setColor(Color.GREEN);
                    time_start = System.currentTimeMillis();
                    checkedAnswer = true;
                    score += 100;
                    yourScoreName = "Score: " + score;
                }
            }
        });

        btnAnswer3.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(!question.checkAnswer(String.valueOf(btnAnswer3.getText()))){
                    timeBar.setVisible(false);
                    btnAnswer3.setColor(Color.RED);
                    time_start = System.currentTimeMillis();
                    checkedAnswer = true;
                    score -= 100;
                    yourScoreName = "Score: " + score;
                }else{
                    timeBar.setVisible(false);
                    btnAnswer3.setColor(Color.GREEN);
                    time_start = System.currentTimeMillis();
                    checkedAnswer = true;
                    score += 100;
                    yourScoreName = "Score: " + score;
                }
            }
        });

        btnAnswer4.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if(!question.checkAnswer(String.valueOf(btnAnswer4.getText()))){
                    timeBar.setVisible(false);
                    btnAnswer4.setColor(Color.RED);
                    time_start = System.currentTimeMillis();
                    checkedAnswer = true;
                    score -= 100;
                    yourScoreName = "Score: " + score;
                }else{
                    timeBar.setVisible(false);
                    btnAnswer4.setColor(Color.GREEN);
                    time_start = System.currentTimeMillis();
                    checkedAnswer = true;
                    score += 100;
                    yourScoreName = "Score: " + score;
                }
            }
        });

        btnMenu.setVisible(true);
        btnMenu.setTouchable(Touchable.enabled);
        btnMenu.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                //TODO Si se clica que vaya al MENU
            }
        });

        btnRetry.addListener(new ClickListener(){
            @Override
            public void clicked(InputEvent event, float x, float y) {
                btnScore.setVisible(false);
                btnRetry.setVisible(false);
                score = 0;
                yourScoreName = "Score: " + score;
                QuestionsStack.getQuestionsStack().chooseQuestions();
//                configButtons();
                loadQuestion();
            }
        });

        configButtons();
        loadQuestion();
    }

    private void buildTimer() {
        float delay = 1; // seconds
        timer = Timer.schedule(new Timer.Task(){

            @Override
            public void run() {
                startQuestion = true;
            }

            public void cancel(){
                startQuestion = false;
            }

        }, delay);
    }

    public void update(float delta) {
        if(startQuestion) {
            playTime = System.currentTimeMillis() - time_start;
            timeBar.setValue(playTime);
            if(playTime >= TIME_LIMIT){
                timer.cancel();
                loadQuestion();
                score -= 100;
                yourScoreName = "Score: " + score;
            }

            if(checkedAnswer){
                if(System.currentTimeMillis() - time_start >= 1000){
                    btnAnswer1.setColor(Color.valueOf("666666"));
                    btnAnswer2.setColor(Color.valueOf("666666"));
                    btnAnswer3.setColor(Color.valueOf("666666"));
                    btnAnswer4.setColor(Color.valueOf("666666"));
                    timeBar.setVisible(true);
                    checkedAnswer = false;
                    loadQuestion();
                }
            }
        }
    }

    private void correctAnswer(TextButton textButton){
        timer.cancel();

        textButton.setColor(Color.valueOf("666666"));
        loadQuestion();
        timeBar.setVisible(true);
    }

    private void incorrectAnswer(TextButton textButton){
        textButton.setColor(Color.RED);

        timer.cancel();
        timeBar.setVisible(false);

        textButton.setColor(Color.valueOf("666666"));
        loadQuestion();
        timeBar.setVisible(true);
    }

    public void loadQuestion(){
        question = QuestionsStack.getQuestionsStack().loadQuestion();
        if (question == null){
            btnScore.setText(yourScoreName);
            btnScore.setVisible(true);
            btnRetry.setVisible(true);
            return;
        }

        taPhrase.setText(question.getPhrase());

        btnAnswer1.setText(question.getPossibleAnswers()[0]);
        btnAnswer2.setText(question.getPossibleAnswers()[1]);
        btnAnswer3.setText(question.getPossibleAnswers()[2]);
        btnAnswer4.setText(question.getPossibleAnswers()[3]);
        timer.run();
        time_start = System.currentTimeMillis();
    }

    public void configButtons(){
        float xArea = screenWidth/12;
        float yArea = (screenHeight/2)+((screenHeight/2)/3);
        float xField = screenWidth/5;
        float yField = screenHeight/16;

        this.taPhrase.setX(xArea);
        this.taPhrase.setY(yArea);
        taPhrase.setWidth(screenWidth - 2 * xArea);
        taPhrase.setHeight((screenHeight / 2) - (2 * ((screenHeight / 6))));
        taPhrase.setDisabled(true);


        this.btnAnswer1.setPosition(xField, yField + (screenWidth / 7) * 2);
        this.btnAnswer1.setWidth(screenWidth - (2 * xField));

        this.btnAnswer2.setPosition(xField, yField + (screenWidth / 7) * 3);
        this.btnAnswer2.setWidth(screenWidth - (2 * xField));

        this.btnAnswer3.setPosition(xField, yField + (screenWidth / 7) * 4);
        this.btnAnswer3.setWidth(screenWidth - (2 * xField));

        this.btnAnswer4.setPosition(xField, yField + (screenWidth / 7) * 5);
        this.btnAnswer4.setWidth(screenWidth - (2 * xField));

        this.btnMenu.setPosition(screenWidth/25,screenHeight-(screenHeight/12));
        this.btnMenu.setWidth(screenWidth/10);
        this.btnMenu.setHeight(screenHeight/25);

        this.btnScore.setPosition((screenWidth / 2) - (screenWidth / 6), screenHeight / 2);
        this.btnScore.setWidth(screenWidth / 3);
        this.btnScore.setHeight(screenHeight / 6);
        this.btnRetry.setWidth(screenWidth/6);
        this.btnRetry.setHeight(screenHeight/10);
        this.btnRetry.setPosition(btnScore.getX()+(btnRetry.getWidth()/2), screenHeight/4);

        this.timeBar.setPosition(xField+xField/2, screenHeight / 10);
        this.timeBar.setSize(screenWidth - (3 * xField),timeBar.getPrefHeight());

        btnRetry.setColor(Color.valueOf("0042ff"));
        btnScore.setColor(Color.valueOf("6be852"));
        btnAnswer1.setColor(Color.valueOf("666666"));
        btnAnswer2.setColor(Color.valueOf("666666"));
        btnAnswer3.setColor(Color.valueOf("666666"));
        btnAnswer4.setColor(Color.valueOf("666666"));

    }
    public TextArea getTaPhrase() {
        return taPhrase;
    }

    public TextButton getBtnAnswer1() {
        return btnAnswer1;
    }

    public TextButton getBtnAnswer2() {
        return btnAnswer2;
    }

    public TextButton getBtnAnswer3() {
        return btnAnswer3;
    }

    public TextButton getBtnAnswer4() {
        return btnAnswer4;
    }

    public ProgressBar getTimeBar() { return timeBar;}

    public  SpriteBatch getBatch() {return this.batch;}

    public BitmapFont getYourBitmapFontName() {return this.yourBitmapFontName;}

    public String getYourScoreName() {return this.yourScoreName;}

    public TextButton getBtnScore() {return btnScore;}

    public TextButton getBtnMenu() {return btnMenu;}

    public TextButton getBtnRetry() { return btnRetry;}
}
