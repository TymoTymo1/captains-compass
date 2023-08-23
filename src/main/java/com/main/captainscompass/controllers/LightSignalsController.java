package com.main.captainscompass.controllers;

import com.main.captainscompass.App;
import com.main.captainscompass.quizzes.LightSignals;
import com.main.captainscompass.quizzes.QuizUtils;
import com.main.captainscompass.scenes.Scenes;
import com.main.captainscompass.scenes.SceneManager;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;

public class LightSignalsController extends Controller implements Initializable {
    private static final int NUMBER_OF_ANSWERS = 3;
    @FXML
    ImageView quizImage;
    @FXML
    private Button answer1;
    @FXML
    private Button answer2;
    @FXML
    private Button answer3;
    @FXML
    private Button next;

    private int correct;
    private Button[] buttons;

    @FXML
    void goBack(MouseEvent event) {
        Stage activeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        SceneManager.changeScene(Scenes.MAIN_SCENE, activeStage);
    }

    @FXML
    void submitAnswer(MouseEvent event) {
        Button clicked = (Button)event.getSource();
        int index = Arrays.asList(buttons).indexOf(clicked);
        if (index == correct) {
        } else {
            clicked.getStyleClass().add("incorrect-answer");
        }

        buttons[correct].getStyleClass().add("correct-answer");
        next.setDisable(false);

        for (Button button: buttons) {
            if (button.equals(clicked)) continue;
            button.setDisable(true);
        }
    }

    @FXML
    void next(MouseEvent event) {
        resetStyles();
        loadQuiz();
    }

    @Override
    public void onSceneLoaded() {
        resetStyles();
        loadQuiz();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttons = new Button[] {answer1, answer2, answer3};
    }

    private void resetStyles() {
        for (Button button: buttons) {
            button.getStyleClass().remove("incorrect-answer");
            button.getStyleClass().remove("correct-answer");
        }
        for (Button button: buttons) {
            button.setDisable(false);
        }
    }

    private void loadQuiz() {
        LightSignals.QuizSet quizSet = LightSignals.getRandomQuizSet();
        String[] possibleAnswers = quizSet.getPossibleAnswers();

        URL imageUrl = App.class.getResource(quizSet.getFile());
        if (imageUrl != null) {
            quizImage.setImage(new Image(imageUrl.toExternalForm()));
        } else {
            System.err.println("Quiz image could not be loaded");
        }

        List<Integer> answerIndices = QuizUtils.generateRandomSequence(3);
        this.correct = answerIndices.indexOf(0);

        for (int i = 0; i < NUMBER_OF_ANSWERS; i++) {
            buttons[i].setText(possibleAnswers[answerIndices.get(i)]);
        }
    }
}
