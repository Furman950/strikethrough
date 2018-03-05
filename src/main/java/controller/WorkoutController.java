package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.CustomWorkout;
import model.Meal;
import model.User;
import model.Workout;

import java.awt.event.MouseEvent;
import java.io.IOException;

public class WorkoutController
{
        private StrikethroughMainController controller = new StrikethroughMainController();
        private User userLoggedIn = controller.getUserLoggedIn();

        private String workoutName, sets, reps;

        @FXML
        private TextField wName, set, rep;

        @FXML
        private Button submit;

        @FXML
        private Label label;

    @FXML
    public void initialize() {
        Platform.runLater( () -> label.requestFocus() );
    }

    public WorkoutController() throws IOException {
        }
    public void customWorkout(MouseEvent e) {

        workoutName = wName.getText();
        sets = set.getText();
        reps = rep.getText();

        Workout custom = new CustomWorkout(Integer.parseInt(reps), Integer.parseInt(sets), workoutName);

        userLoggedIn.setWorkouts(custom);
        System.out.println("click");
    }

    public void generatedWorkout(MouseEvent e)
    {

    }

}
