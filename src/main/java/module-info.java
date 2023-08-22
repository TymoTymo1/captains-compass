module com.main.captainscompass {
    requires javafx.controls;
    requires javafx.fxml;
    requires de.jensd.fx.glyphs.fontawesome;

    opens com.main.captainscompass to javafx.fxml;
    exports com.main.captainscompass;
    exports com.main.captainscompass.controllers;
    opens com.main.captainscompass.controllers to javafx.fxml;
    exports com.main.captainscompass.scenes;
    opens com.main.captainscompass.scenes to javafx.fxml;
}