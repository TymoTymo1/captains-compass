package com.main.captainscompass.controllers;

import com.main.captainscompass.scenes.SceneManager;
import com.main.captainscompass.scenes.Scenes;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public abstract class QuizController extends Controller{
    @FXML
    protected Button next;

    @FXML
    void goBack(MouseEvent event) {
        Stage activeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        SceneManager.changeScene(Scenes.MAIN_SCENE, activeStage);
    }

    @FXML
    void next(MouseEvent event) {
        resetStyles();
        loadQuiz();
    }
    public void onSceneLoaded() {
        resetStyles();
        loadQuiz();
    }

    abstract void resetStyles();
    abstract void loadQuiz();
}
