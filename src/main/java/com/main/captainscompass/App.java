package com.main.captainscompass;

import com.main.captainscompass.quizzes.LightSignals;
import com.main.captainscompass.scenes.Scenes;
import com.main.captainscompass.scenes.SceneManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {
    private static final String MAIN_FXML = "main-view.fxml";
    private static final String LIGHT_SIGNALS_FXML = "light-signals.fxml";

    @Override
    public void start(Stage stage) throws IOException {
        addScenes();
        initQuizzes();
        SceneManager.changeScene(Scenes.MAIN_SCENE, stage);
    }

    private void addScenes() throws IOException {
        SceneManager.addScene(MAIN_FXML, Scenes.MAIN_SCENE);
        SceneManager.addScene(LIGHT_SIGNALS_FXML, Scenes.LIGHT_SIGNALS_SCENE);
    }

    private void initQuizzes() {
        LightSignals.init("assets/lightSignals");
    }

    public static void main(String[] args) {
        launch();
    }
}