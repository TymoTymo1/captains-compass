module com.main.captainscompass {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.main.captainscompass to javafx.fxml;
    exports com.main.captainscompass;
    exports com.main.captainscompass.controllers;
    opens com.main.captainscompass.controllers to javafx.fxml;
}