package com.main.captainscompass.controllers;

import com.main.captainscompass.App;
import com.main.captainscompass.quizzes.LightSignals;
import com.main.captainscompass.scenes.Scenes;
import com.main.captainscompass.scenes.SceneManager;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;

public class LightSignalsController extends Controller{

    @FXML
    ImageView quizImage;
    @FXML
    Label quizLabel;

    @FXML
    void goBack(MouseEvent event) {
        Stage activeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
        SceneManager.changeScene(Scenes.MAIN_SCENE, activeStage);
    }

    @Override
    public void onSceneLoaded() {
        LightSignals.QuizSet quizSet = LightSignals.getRandomQuizSet();
        URL imageUrl = App.class.getResource(quizSet.getFile());
        if (imageUrl != null) {
            quizImage.setImage(new Image(imageUrl.toExternalForm()));
        } else {
            System.err.println("Quiz image could not be loaded");
        }
    }
}
