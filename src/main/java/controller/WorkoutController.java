package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import java.io.IOException;

public class WorkoutController {
    @FXML
    private Label label;

    @FXML
    AnchorPane workout, WorkoutGenerator, customWorkouts, mainMenu;

    @FXML
    public void initialize() {
        Platform.runLater(() -> label.requestFocus());
    }

    /**
     *
     * @throws IOException
     */
    public WorkoutController() throws IOException {}

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void custom(MouseEvent mouseEvent) throws IOException {
        customWorkouts = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/CustomWorkout.fxml"));
        workout.getChildren().setAll(customWorkouts);
    }

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void generate(MouseEvent mouseEvent) throws IOException {
        WorkoutGenerator = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/WorkoutGenerator.fxml"));
        workout.getChildren().setAll(WorkoutGenerator);
    }

    /**
     *
     * @param mouseEvent
     * @throws IOException
     */
    public void goBack(MouseEvent mouseEvent) throws IOException {
        mainMenu = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/MainMenu.fxml"));
        workout.getChildren().setAll(mainMenu);

    }
}
