package com.main.captainscompass.controllers;

import com.main.captainscompass.scenes.Scenes;
import com.main.captainscompass.scenes.Utils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LightSignalsController implements Initializable {

    @FXML
    ImageView quizImage;
    @FXML
    Label quizLabel;

    @FXML
    void goBack(MouseEvent event) throws IOException {
        Stage activeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Utils.changeScene(Scenes.MAIN_SCENE, activeStage);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
