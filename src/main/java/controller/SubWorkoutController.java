package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.MuscleGroups;

import java.io.IOException;

public class SubWorkoutController {
    @FXML
    AnchorPane WorkoutGenerator, workout, CustomWorkout;

    @FXML
    ComboBox muscleGroup;

    @FXML
    public void initialize() {
        if (muscleGroup != null) {
            muscleGroup.getItems().addAll(MuscleGroups.values());
        }
    }

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
