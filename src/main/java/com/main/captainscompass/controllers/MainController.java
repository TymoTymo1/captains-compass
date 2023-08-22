package com.main.captainscompass.controllers;

import com.main.captainscompass.App;
import com.main.captainscompass.scenes.LightSignals;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainController {
    private static final String LIGHT_SIGNALS_FXML = "light-signals.fxml";

    @FXML
    private VBox lightSignals;

    private Stage stage;

    @FXML
    void startLightSignalsQuiz(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(App.class.getResource(LIGHT_SIGNALS_FXML));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new LightSignals(loader, 1000, 800));
    }
}
