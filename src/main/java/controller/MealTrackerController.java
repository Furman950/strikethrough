package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.Meal;
import model.User;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

public class MealTrackerController {

    private StrikethroughMainController strikethrough = new StrikethroughMainController();
    private User userLoggedIn = strikethrough.getUserLoggedIn();

    private String mealName;
    private int calories, totalFat, satFat, unsatFat, sodium, carbs, sugar, protein, cholesterol, numServing;
    private int day, month, year;

    @FXML
    private TextField mName, kalories, tFat, sFat, usFat, NaCl, karbs, shugar, brotein, cholset, nServing, tDay;

    @FXML
    private AnchorPane meal, mainMenu, mealInfo;

    @FXML
    private Label label;

    public MealTrackerController() throws IOException {
    }

    @FXML
    public void initialize() {
        Platform.runLater(() -> label.requestFocus());
    }

    public void addMeal(MouseEvent mouseEvent) throws IOException {
        mealInfo = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/MealInfo.fxml"));
        meal.getChildren().setAll(mealInfo);

    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        mainMenu = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/MainMenu.fxml"));
        meal.getChildren().setAll(mainMenu);
    }


    public void submitMeal(MouseEvent mouseEvent) {
        Alert mAlert = new Alert(Alert.AlertType.INFORMATION);
        mAlert.setTitle("Meal");

        if (mName.getText().trim().equals("") || mName.getText().equals(null)) {
            mAlert.setContentText("Meal name cannot be empty!!");
        } else {
            mealName = mName.getText().trim();
            try {
                calories = Integer.parseInt(kalories.getText());
                totalFat = Integer.parseInt(tFat.getText());
                satFat = Integer.parseInt(sFat.getText());
                unsatFat = Integer.parseInt(usFat.getText());
                sodium = Integer.parseInt(NaCl.getText());
                carbs = Integer.parseInt(karbs.getText());
                sugar = Integer.parseInt(shugar.getText());
                protein = Integer.parseInt(brotein.getText());
                cholesterol = Integer.parseInt(cholset.getText());
                Calendar cal = Calendar.getInstance();
                cal.clear();
                cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
                strikethrough.getUserLoggedIn().setMeals(cal, new Meal(mealName, calories, totalFat, satFat, unsatFat, sodium, carbs, sugar, cholesterol, protein, numServing));
                Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
                alert1.setTitle("Successful");
                alert1.setContentText("Added meal to today's date successfully!!!");
                alert1.show();
            } catch (NumberFormatException e) {
                mAlert.setContentText("Invalid number in one of the fields");
            }
        }
    }

    public void searchMeal(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        StringBuilder listOfMeals = new StringBuilder();
        Calendar searchDate = Calendar.getInstance();
        searchDate.clear();
        checkDate();
        searchDate.set(year, month, day);
        alert.setTitle("Meal");

        if (strikethrough.getUserLoggedIn().getMeals().isEmpty()) {
            alert.setContentText("No Meals found");
            alert.show();
            return;
        }

        for (Map.Entry<Calendar, Meal> m : strikethrough.getUserLoggedIn().getMeals().entrySet()) {

            System.out.println(strikethrough.getUserLoggedIn().getMeals().toString());
            if (m.getKey().equals(searchDate)) {
                listOfMeals.append("Date: " + m.getKey().get(Calendar.MONTH) +
                        "/" + m.getKey().get(Calendar.DAY_OF_MONTH) +
                        "/" + m.getKey().get(Calendar.YEAR) + "\nMeal: " + m.getValue() + "\n");
            }
        }

        alert.setContentText(listOfMeals.toString());
        alert.show();

    }


    public void back(MouseEvent mouseEvent) throws IOException {
        meal = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/Meal.fxml"));
        mealInfo.getChildren().setAll(meal);
    }

    private void checkDate() {
        String[] date = tDay.getText().split("/");

        try {
            if (date.length != 3) {
                throw new IllegalArgumentException("Invalid date format!!");
            }

            month = Integer.parseInt(date[0].trim());
            day = Integer.parseInt(date[1].trim());
            year = Integer.parseInt(date[2].trim());

            if (day <= 0 || day > 31) {
                System.out.println("Day");
                throw new IllegalArgumentException("Invalid day");
            }

            if (month <= 0 || month > 12) {
                System.out.println("Month");
                throw new IllegalArgumentException("Invalid month");
            } else {
                month--;
            }

            if (year < 1901 || year > Calendar.getInstance().get(Calendar.YEAR)) {
                throw new IllegalArgumentException("Invalid date");
            }
        } catch (IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid date");
            alert.setContentText("Please make sure the date is in mm/dd/yyyy format!");
            alert.show();
        }
    }
}
