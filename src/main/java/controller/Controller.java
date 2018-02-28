package controller;

import exceptions.InvalidUsernameOrPasswordException;
import exceptions.UserAlreadyExistsException;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Birthday;
import model.Meal;
import model.User;
import model.UserData;

public class Controller 
{
	private UserData userD = new UserData();
	private boolean login = false;
	private User logs;
	@FXML
	private TextField uName, pWord, fName;
	
	@FXML
	private TextField height, weight, gWeight, month, day, year;
	
	private String firstName, username, password, height1, weight1, goalWeight, bMonth, bDay, bYear;
	
	private String mealName, calories, totalFat, satFat, unsatFat, sodium, carbs, sugar, protein, cholest, numServing;

	@FXML private TextField mName, kalories, tFat, sFat, usFat, NaCl, karbs, shugar, brotein, cholset, nServing;
	private Birthday birthday;
	
	/**
	 * Creates a new user profile
	 */
	public void register() 
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
	public void login() 
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

		Meal meal = new Meal(mealName, Integer.parseInt(calories), Integer.parseInt(totalFat), Integer.parseInt(satFat), Integer.parseInt(unsatFat),
				Integer.parseInt(sodium), Integer.parseInt(carbs), Integer.parseInt(sugar), Integer.parseInt(cholest), Integer.parseInt(protein), Integer.parseInt(numServing));
	}
	
	
	public void weightTracker(MouseEvent e)
	{
		
	}
	public void exit(MouseEvent e)
	{

		System.exit(0);
	}
	
}
