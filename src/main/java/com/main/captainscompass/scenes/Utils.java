package com.main.captainscompass.scenes;

import com.main.captainscompass.App;
import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class Utils {
    private static final HashMap<String, Scene> scenes = new HashMap<>();

    public static void changeScene(String scene, Stage stage) throws IOException {
        stage.setScene(scenes.get(scene));
        stage.show();
    }

    private static Scene loadScene(String fxml, Stage stage, String title) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(fxml));
        return new Scene(loader.load(), 1000, 800);
    }

    public static void addScene(String name, String fxml, Stage stage, String title) throws IOException {
        Scene newScene = loadScene(fxml, stage, title);
        scenes.put(name, newScene);
    }
}
