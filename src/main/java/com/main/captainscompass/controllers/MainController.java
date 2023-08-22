package com.main.captainscompass.controllers;

import com.main.captainscompass.scenes.Scenes;
import com.main.captainscompass.scenes.Utils;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {

    @FXML
    void startLightSignalsQuiz(MouseEvent event) throws IOException {
        Stage activeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Utils.changeScene(Scenes.LIGHT_SIGNALS_SCENE, activeStage);
    }
}
