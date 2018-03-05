package controller;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Meal;
import model.UserData;

import static controller.StrikethroughMainController.userD;

public class MealTrackerController {

    private UserData userD = new UserData();

    private String mealName, calories, totalFat, satFat, unsatFat, sodium, carbs, sugar, protein, cholest, numServing, date;

    @FXML
    private TextField mName, kalories, tFat, sFat, usFat, NaCl, karbs, shugar, brotein, cholset, nServing, day;

    @FXML
    private Button submit;

    @FXML
    private Label label;

    @FXML
    public void initialize() {
        Platform.runLater( () -> label.requestFocus() );
    }

    public void mealTracker(MouseEvent e) {
        date = day.getText();
    }

    public void mealInfo(MouseEvent e)
    {
        mealName = mName.getText();
        calories = kalories.getText();
        totalFat = tFat.getText();
        satFat = sFat.getText();
        unsatFat = usFat.getText();
        sodium = NaCl.getText();
        carbs = karbs.getText();
        sugar = shugar.getText();
        protein = brotein.getText();
        cholest = cholset.getText();
        numServing = nServing.getText();

        Meal meal = new Meal(mealName, Integer.parseInt(calories), Integer.parseInt(totalFat), Integer.parseInt(satFat), Integer.parseInt(unsatFat),
                Integer.parseInt(sodium), Integer.parseInt(carbs), Integer.parseInt(sugar), Integer.parseInt(cholest), Integer.parseInt(protein), Integer.parseInt(numServing), date);

        userD.setMeals(date, meal);
        System.out.println("click");
    }
}
