package com.main.captainscompass.scenes;

import com.main.captainscompass.App;
import com.main.captainscompass.controllers.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class SceneManager {
    private static final HashMap<String, Scene> scenes = new HashMap<>();

    public static void changeScene(String scene, Stage stage) {
        Scene next = scenes.get(scene);
        Object userData = next.getUserData();
        if (userData instanceof Controller) {
            ((Controller)userData).onSceneLoaded();
        }
        stage.setScene(next);
        stage.setTitle(scene);
        stage.show();
    }

    private static Scene loadScene(String fxml) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
        Scene newScene = new Scene(loader.load(), 1000, 800);
        newScene.setUserData(loader.getController());
        return newScene;
    }

    public static void addScene(String fxml, String title) throws IOException {
        Scene newScene = loadScene(fxml);
        scenes.put(title, newScene);
    }
}
