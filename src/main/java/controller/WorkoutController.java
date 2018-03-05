package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class WorkoutController
{
    @FXML
    private Label label;

    public void initialize() {
        Platform.runLater( () -> label.requestFocus() );
    }
}
