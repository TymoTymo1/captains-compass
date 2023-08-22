package com.main.captainscompass;

import com.main.captainscompass.controllers.MainController;
import com.main.captainscompass.scenes.Scenes;
import com.main.captainscompass.scenes.Utils;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class App extends Application {
    private static final String MAIN_FXML = "main-view.fxml";
    private static final String LIGHT_SIGNALS_FXML = "light-signals.fxml";

    @Override
    public void start(Stage stage) throws IOException {
        addScenes(stage);
        Utils.changeScene(Scenes.MAIN_SCENE, stage);
    }

    private void addScenes(Stage stage) throws IOException {
        Utils.addScene(Scenes.MAIN_SCENE, MAIN_FXML, stage, "Captain's Compass");
        Utils.addScene(Scenes.LIGHT_SIGNALS_SCENE, LIGHT_SIGNALS_FXML, stage, "Light Signals Quiz");
    }

    public static void main(String[] args) {
        launch();
    }
}