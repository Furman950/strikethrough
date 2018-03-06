package controller;


import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import model.WeightTracker;

import java.io.IOException;
import java.util.Calendar;
import java.util.Map;

public class WeightTrackerController {
    private StrikethroughMainController strikethrough = new StrikethroughMainController();

    private int weight;
    private int day;
    private int month;
    private int year;

    private boolean invalidDate = false;

    @FXML
    private TextField data;

    @FXML
    private Label label;

    @FXML
    private AnchorPane WeightTracker, MainMenu;

    @FXML
    public void initialize() {
        Platform.runLater(() -> label.requestFocus());
    }

    public WeightTrackerController() throws IOException {
    }


    /**
     * Addes weight user enters for today's date
     * @param mouseEvent
     */
    public void addWeight(MouseEvent mouseEvent) {

        try {
            Calendar cal = Calendar.getInstance();
            cal.clear();
            cal.set(Calendar.getInstance().get(Calendar.YEAR), Calendar.getInstance().get(Calendar.MONTH), Calendar.getInstance().get(Calendar.DAY_OF_MONTH));
            weight = Integer.parseInt(data.getText().trim());
            WeightTracker tracker = new WeightTracker(weight);
            System.out.println(strikethrough.getUserLoggedIn().getWeights().toString());
            strikethrough.getUserLoggedIn().setWeights(cal, tracker);
            System.out.println("-------------------------------------------------------");
            System.out.println(strikethrough.getUserLoggedIn().getWeights().toString());
            Alert alert1 = new Alert(Alert.AlertType.CONFIRMATION);
            alert1.setTitle("Successful");
            alert1.setContentText("Added weight to today's date successfully!!!");
            alert1.show();
            data.setText("");
        }
        catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid entry");
            alert.setContentText("Invalid weight!! Did you mean to search for a date?");
            alert.show();
        }

    }

    public void searchForWeight(MouseEvent mouseEvent) {
        invalidDate = false;
        checkDate();
        Calendar searchDate = Calendar.getInstance();
        searchDate.clear();
        searchDate.set(year, month, day);

        for(Map.Entry<Calendar, WeightTracker> wt : strikethrough.getUserLoggedIn().getWeights().entrySet()) {
            if (wt.getKey().equals(searchDate)) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Weight");
                alert.setContentText(wt.getValue().toString());
                alert.show();
                return;
            }
        }
        if (!invalidDate) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("No entry found");
            alert.setContentText("No weight information found!");
            alert.show();
        }
        data.setText("");

    }

    private void checkDate() {
        String[] date = data.getText().split("/");

        try {
            if (date.length != 3){
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
            }
            else {month--;}

            if (year < 1900 || year > Calendar.getInstance().get(Calendar.YEAR)) {
                throw new IllegalArgumentException("Invalid date");
            }
        }
        catch(IllegalArgumentException e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Invalid date");
            alert.setContentText("Please make sure the date is in mm/dd/yyyy format!");
            alert.show();
            invalidDate = true;
        }
    }

    public void goBack(MouseEvent mouseEvent) throws IOException {
        MainMenu = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/MainMenu.fxml"));
        WeightTracker.getChildren().setAll(MainMenu);
    }
}
