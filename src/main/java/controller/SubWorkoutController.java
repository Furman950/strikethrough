package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.CustomWorkout;
import model.GeneratedWorkouts;
import model.MuscleGroups;
import model.Workout;

import java.io.IOException;
import java.util.concurrent.ThreadLocalRandom;

public class SubWorkoutController {
    StrikethroughMainController strikethrough = new StrikethroughMainController();
    @FXML
    AnchorPane WorkoutGenerator, workout, CustomWorkout;

    @FXML
    ComboBox muscleGroup;

    @FXML
    TextField workoutName, workoutReps, workoutSets;

    @FXML
    public void initialize() {
        if (muscleGroup != null) {
            muscleGroup.getItems().add(MuscleGroups.UPPER_BODY.getName());
            muscleGroup.getItems().add(MuscleGroups.LEGS.getName());
            muscleGroup.getItems().add(MuscleGroups.ABS.getName());
        }
    }

    public SubWorkoutController() throws IOException {
    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        workout = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Workout.fxml"));

        if (mouseEvent.getSource().toString().contains("Custom")) {
            CustomWorkout.getChildren().setAll(workout);
        } else {
            WorkoutGenerator.getChildren().setAll(workout);
        }

    }

    public void generateWorkout(MouseEvent mouseEvent) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        int reps;
        int sets;
        GeneratedWorkouts workout = null;

        switch (muscleGroup.getSelectionModel().getSelectedItem().toString()) {
            case "Upper body":
                while (true) {
                    workout = GeneratedWorkouts.randomEnum(GeneratedWorkouts.class);
                    if (workout.getCode() == 1)
                        break;
                }
                System.out.println(workout.getName());
                break;
            case "Legs":
                while (true) {
                    workout = GeneratedWorkouts.randomEnum(GeneratedWorkouts.class);
                    if (workout.getCode() == 2)
                        break;
                }
                System.out.println(workout.getName());
                break;
            case "Abs":
                while (true) {
                    workout = GeneratedWorkouts.randomEnum(GeneratedWorkouts.class);
                    if (workout.getCode() == 3)
                        break;
                }
                System.out.println(workout.getName());
                break;
        }

            reps = ThreadLocalRandom.current().nextInt(5, 15 + 1);
            sets = ThreadLocalRandom.current().nextInt(3, 5 + 1);

            alert.setTitle("Workout Generated");
            alert.setContentText("Workout: " + workout.getName() + "\n" + "Reps: " + reps + "\n" + "Sets: " + sets);
            alert.show();


    }

    public void customWorkout(MouseEvent mouseEvent) {
        System.out.println("Clicked submit");
        Alert cAlert = new Alert(Alert.AlertType.INFORMATION);
        cAlert.setTitle("Invalid Input!");
        String nameOfWorkout;
        int numOfReps, numOfSets;
        nameOfWorkout = workoutName.getText().trim();

        if (nameOfWorkout.equals(null) || nameOfWorkout.equals("")) {
            cAlert.setContentText("Workout name cannot be empty!!");
            cAlert.show();
        } else {
            try {
                numOfReps = Integer.parseInt(workoutReps.getText().trim());
                numOfSets = Integer.parseInt(workoutSets.getText().trim());
                System.out.println("In try");

                if (numOfReps < 0 || numOfSets < 0)
                    throw new NumberFormatException();

                strikethrough.getUserLoggedIn().setWorkouts(new CustomWorkout(nameOfWorkout, numOfReps, numOfSets));
                cAlert.setTitle("Successful");
                cAlert.setContentText("Successfully saved your workout!");
                cAlert.show();

                workoutName.setText("");
                workoutReps.setText("");
                workoutSets.setText("");

            } catch (NumberFormatException e) {
                cAlert.setContentText("Invalid number of reps or sets!!");
                cAlert.show();
            }
        }
    }

    public void viewWorkouts(MouseEvent mouseEvent) {
        Alert wAlert = new Alert(Alert.AlertType.INFORMATION);
        StringBuilder listOfWorkouts = new StringBuilder();
        wAlert.setTitle("Custom workouts");
        if (strikethrough.getUserLoggedIn().getWorkouts().isEmpty()) {
            wAlert.setContentText("No custom workouts found!");
            wAlert.show();
            return;
        }

        for (Workout w : strikethrough.getUserLoggedIn().getWorkouts()) {
            listOfWorkouts.append(w.toString() + "\n");
        }

        wAlert.setContentText(listOfWorkouts.toString());
        wAlert.show();
    }
}