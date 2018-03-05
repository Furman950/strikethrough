package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class User implements Serializable{

    private static final long serialVersionUID = 1L;

	private List<Workout> workouts = new ArrayList<>();
	private Map<String, Meal> meals = new HashMap<>();
	private Map<String, WeightTracker> weights = new HashMap<>();
	
	private String username;
	private String password;
	private String firstName;
	private int height;
	private int weight;
	private Birthday birthday;
	private int goalWeight;
	
	public User() {}
	
	public User(String username, String password, String firstName)
	{
		this.setUsername(username);
		this.setPassword(password);
		this.setFirstName(firstName);
	}

	/**
	 * @return the workouts
	 */
	public List<Workout> getWorkouts() {
		return workouts;
	}
	/**
	 * @param workout the workouts to set
	 */
	public void setWorkouts(Workout workout) {
		this.workouts.add(workout);
	}
	/**
	 * @return the meals
	 */
	public Map<String, Meal> getMeals() {
		return meals;
	}
	/**
	 * @param meal the meals to set
	 */
	public void setMeals(String date, Meal meal) {
		this.meals.put(date,meal);
	}

	public Map<String, WeightTracker> getWeights() {
		return weights;
	}
	/**
	 * @param weight the weights to set
	 */
	public void setWeights(String date, WeightTracker weight) {
		this.weights.put(date, weight);
	}
	
	/**
	 * @return the user
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the user to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}
	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		this.height = height;
	}
	/**
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight;
	}
	/**
	 * @return the birthday
	 */
	public Birthday getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the goalWeight
	 */
	public int getGoalWeight() {
		return goalWeight;
	}
	/**
	 * @param goalWeight the goalWeight to set
	 */
	public void setGoalWeight(int goalWeight) {
		this.goalWeight = goalWeight;
	}
	
	@Override
	public String toString() {
		return "User name: " + this.getUsername() + "\n" + 
				"First name: " + this.getFirstName() + "\n" +
				"Height: " + this.getHeight() + "\n" +
				"Weight: " + this.getWeight() + "\n" +
				"Weight goal: " + this.getGoalWeight() +
				"Birthday: " + this.getBirthday() + "\n";
				
	}
	
	@Override
	public boolean equals(Object obj) {
		User user = (User) obj;
		return this.getUsername() == user.getUsername();
	}
	
	

}
