package controller;

import exceptions.InvalidUsernameOrPasswordException;
import exceptions.UserAlreadyExistsException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.*;

import java.io.*;
import java.util.Calendar;
import java.util.Date;

public class Controller 
{
	private UserData userD = new UserData();
	private boolean login = false;
	private User logs;
	private String fileName = "UserData.rac";
	@FXML
	private TextField uName, pWord, fName;
	
	@FXML
	private TextField height, weight, gWeight, month, day, year;
	
	private String firstName, username, password, height1, weight1, goalWeight, bMonth, bDay, bYear;
	
	private String mealName, calories, totalFat, satFat, unsatFat, sodium, carbs, sugar, protein, cholest, numServing, date;

	@FXML
	private TextField mName, kalories, tFat, sFat, usFat, NaCl, karbs, shugar, brotein, cholset, nServing, calendar;
	private Birthday birthday;

	@FXML
	private TextField tWeight;

	private String trackWeight;

	@FXML
	private TextField wName, sets, reps;

	private String workoutName, set, rep;
	
	/**
	 * Creates a new user profile
	 */
	public void register(MouseEvent e)
	{
		username = uName.getText();
		password = pWord.getText();
		firstName = fName.getText();
		
		for(User u: this.userD.getUsers())
		{
			if(u.getUsername().equalsIgnoreCase(username))
			{
				throw new UserAlreadyExistsException("Username already exists.");
			}
		}

		User user = new User(username, password, firstName);
		userD.setUsers(user);
	}
	
	/**
	 * collects user data to fill in their profile
	 */
	public void info()
	{
		height1 = height.getText();
		weight1 = weight.getText();
		bMonth = month.getText();
		bDay = day.getText();
		bYear = year.getText();
		goalWeight = gWeight.getText();
		
		birthday = new Birthday(Integer.parseInt(bDay),Integer.parseInt(bMonth),Integer.parseInt(bYear));
	
		int height2 = Integer.parseInt(height1);
		int weight2 = Integer.parseInt(weight1);
		int goalWeight1 = Integer.parseInt(goalWeight);
		
		logs.setHeight(height2);
		logs.setWeight(weight2);
		logs.setBirthday(birthday);;
		logs.setGoalWeight(goalWeight1);
	}

	/**
	 * logs in an existing profile
	 */
	public void login(MouseEvent e)
	{
		username = uName.getText();
		password = pWord.getText();
		
		for(User u: this.userD.getUsers())
		{
			if(u.getUsername().equalsIgnoreCase(username))
			{
				if(u.getPassword().equals(password))
				{
					login = true;
					logs = u;
				}
			}
		}
		
		if(!login)
		{
			throw new InvalidUsernameOrPasswordException("Username or Password is incorrect.");
		}
	}
	
	public void mealTracker(MouseEvent e)
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
		date = calendar.getText();

		Meal meal = new Meal(mealName, Integer.parseInt(calories), Integer.parseInt(totalFat), Integer.parseInt(satFat), Integer.parseInt(unsatFat),
				Integer.parseInt(sodium), Integer.parseInt(carbs), Integer.parseInt(sugar), Integer.parseInt(cholest), Integer.parseInt(protein), Integer.parseInt(numServing));

		userD.setMeals(date, meal);
	}
	
	
	public void weightTracker(MouseEvent e)
	{
		trackWeight = tWeight.getText();
		date = calendar.getText();

		WeightTracker tracked = new WeightTracker(Integer.parseInt(trackWeight));

		userD.setWeights(date, tracked);
	}
	public void exit(MouseEvent e)
	{
		System.exit(0);
	}

    /**
     * Saves all users and their data
     *
     * @throws IOException
     */
    public void saveData() throws IOException {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(fileName))) {
            out.writeObject(this.userD);
        }
    }

    /**
     * Loads all the users and their data
     *
     * @throws IOException
     */
    public void loadData() throws IOException {
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName))){
            try {
                this.userD = (UserData) in.readObject();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
	public void customWorkout(MouseEvent e)
	{
		workoutName = wName.getText();
		set = sets.getText();
		rep = reps.getText();

		Workout workout = new CustomWorkout(Integer.parseInt(rep), Integer.parseInt(set),workoutName);

		userD.setWorkouts(workout);
	}
	
}
