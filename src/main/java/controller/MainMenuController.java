package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class MainMenuController {
    StrikethroughMainController strikethrough = new StrikethroughMainController();


    @FXML
    AnchorPane MainMenu, LoginPage, WeightTrack, MealTrack, WorkoutPlan;

    public MainMenuController() throws IOException {
        System.out.println(strikethrough.getUserLoggedIn().toString());
    }



    public void logout(MouseEvent mouseEvent) throws IOException {
        strikethrough.setUserLoggedIn(null);
        strikethrough.saveData();
        LoginPage = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/LoginPage.fxml"));
        MainMenu.getChildren().setAll(LoginPage);
        System.out.println("-----------------------------" + strikethrough.getUserLoggedIn());

    }

    public void weightTracker(MouseEvent mouseEvent) throws IOException {
        WeightTrack = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/WeightTracker.fxml"));
        MainMenu.getChildren().setAll(WeightTrack);
    }

    public void mealTracker(MouseEvent mouseEvent) throws IOException {
        MealTrack = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Meal.fxml"));
        MainMenu.getChildren().setAll(MealTrack);
    }

    public void workoutPlanner(MouseEvent mouseEvent) throws IOException {
        WorkoutPlan = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Workout.fxml"));
        MainMenu.getChildren().setAll(WorkoutPlan);
    }
}
