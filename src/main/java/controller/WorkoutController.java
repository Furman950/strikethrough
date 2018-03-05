package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.event.MouseEvent;

public class WorkoutController
{
    @FXML
    private Label label;

    public void initialize() {
        Platform.runLater( () -> label.requestFocus() );
    }

    public void customWorkout(MouseEvent e) {

    }

    public void generatedWorkout(MouseEvent e) {

    }

}
