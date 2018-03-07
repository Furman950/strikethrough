package model;

import java.io.Serializable;
import java.util.*;

public class User implements Serializable{

    private static final long serialVersionUID = 1L;

	private List<Workout> workouts = new ArrayList<>();
	private Map<Calendar, Meal> meals = new HashMap<>();
	private Map<Calendar, WeightTracker> weights = new HashMap<>();
	
	private String username;
	private String password;
	private String firstName;
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

	public User(String username, String password, String firstName, int uWeight, int uGoalWeight, Birthday uBirthday) {
        this.setUsername(username);
        this.setPassword(password);
        this.setFirstName(firstName);
        this.setWeight(uWeight);
        this.setGoalWeight(uGoalWeight);
        this.setBirthday(uBirthday);
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
	public Map<Calendar, Meal> getMeals() {
		return meals;
	}
	/**
	 * @param meal the meals to set
	 */
	public void setMeals(Calendar date, Meal meal) {
		this.meals.put(date,meal);
	}

	public Map<Calendar, WeightTracker> getWeights() {
		return weights;
	}
	/**
	 * @param weight the weights to set
	 */
	public void setWeights(Calendar cal, WeightTracker weight) {
	    weights.put(cal, weight);
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
	    if (username.equals(null) || username.equals(""))
	        throw new IllegalArgumentException("Invalid username");

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
	    if (password.equals(null) || password.equals(""))
	        throw new IllegalArgumentException("Invalid password");

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
        if (firstName.equals(null) || firstName.equals(""))
            throw new IllegalArgumentException("Invalid name");
		this.firstName = firstName;
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
