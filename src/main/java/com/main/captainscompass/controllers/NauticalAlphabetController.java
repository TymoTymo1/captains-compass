package com.main.captainscompass.controllers;

import com.main.captainscompass.quizzes.NauticalAlphabet;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class NauticalAlphabetController extends QuizController{
    @FXML
    private Text character;
    @FXML
    private Button next;
    @FXML
    private TextField userInput;
    @FXML
    private Label correction;

    private String answer;

    @FXML
    void submitAnswer() {
        String userAns = userInput.getText().toLowerCase().trim();
        if (userAns.equals(answer)) {
            correction.setText("Correct");
            correction.getStyleClass().add("correct-answer");
        } else {
            correction.setText("Incorrect. Correct answer: " + answer);
            correction.getStyleClass().add("incorrect-answer");
        }
        next.setDisable(false);
    }

    @Override
    void resetStyles() {
        next.setDisable(true);
        correction.getStyleClass().clear();
        correction.setText("");
        userInput.setText("");
    }

    @Override
    void loadQuiz() {
        NauticalAlphabet.QuizSet quizSet = NauticalAlphabet.getRandomQuizSet();
        this.answer = quizSet.getAnswer().toLowerCase();
        character.setText(quizSet.getCharacter());
    }
}
