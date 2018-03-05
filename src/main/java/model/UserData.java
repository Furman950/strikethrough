package model;

import java.io.Serializable;
import java.util.*;

public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Workout> workouts = new ArrayList<>();
	private Map<String, Meal> meals = new HashMap<String, Meal>();
	private List<User> users;
	private Map<String, WeightTracker> weights;
	
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
	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param user the users to set
	 */
	public void setUsers(User user) {
		this.users.add(user);
	}
	/**
	 * @return the weights
	 */
	public Map<String, WeightTracker> getWeights() {
		return weights;
	}
	/**
	 * @param weight the weights to set
	 */
	public void setWeights(String date, WeightTracker weight) {
		this.weights.put(date, weight);
	}
	
}
