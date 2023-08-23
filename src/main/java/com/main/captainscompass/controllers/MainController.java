package com.main.captainscompass.controllers;

import com.main.captainscompass.quizzes.LightSignals;
import com.main.captainscompass.scenes.Scenes;
import com.main.captainscompass.scenes.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController extends Controller{

    @FXML
    void startLightSignalsQuiz(MouseEvent event) {
        Stage activeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        SceneManager.changeScene(Scenes.LIGHT_SIGNALS_SCENE, activeStage);
    }

    @Override
    public void onSceneLoaded() {
    }
}
