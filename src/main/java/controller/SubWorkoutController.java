package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SubWorkoutController {
    @FXML
    AnchorPane WorkoutGenerator, workout, CustomWorkout;

    public void goBack(MouseEvent mouseEvent) throws IOException {
        workout = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Workout.fxml"));

        if (mouseEvent.getSource().toString().contains("Custom")) {
            CustomWorkout.getChildren().setAll(workout);
        }
        else {
            WorkoutGenerator.getChildren().setAll(workout);
        }

    }
}
