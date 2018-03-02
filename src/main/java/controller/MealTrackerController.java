package controller;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import model.Meal;

import static controller.StrikethroughMainController.userD;

public class MealTrackerController {

    private String mealName, calories, totalFat, satFat, unsatFat, sodium, carbs, sugar, protein, cholest, numServing;


    public void mealTracker(MouseEvent e)
    {
  /*      mealName = mName.getText();
        calories = kalories.getText();
        totalFat = tFat.getText();
        satFat = sFat.getText();
        unsatFat = usFat.getText();
        sodium = NaCl.getText();
        carbs = karbs.getText();
        sugar = shugar.getText();
        protein = brotein.getText();
        cholest = cholset.getText();
        numServing = nServing.getText();*/

        Meal meal = new Meal(mealName, Integer.parseInt(calories), Integer.parseInt(totalFat), Integer.parseInt(satFat), Integer.parseInt(unsatFat),
                Integer.parseInt(sodium), Integer.parseInt(carbs), Integer.parseInt(sugar), Integer.parseInt(cholest), Integer.parseInt(protein), Integer.parseInt(numServing));

        //userD.setMeals(meal);
    }
}
