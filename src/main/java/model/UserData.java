package model;

import java.io.Serializable;
import java.util.List;

public class UserData implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<Workout> workouts;
	private List<Meal> meals;
	private List<User> users;
	private List<WeightTracker> weights;
	
	/**
	 * @return the workouts
	 */
	public List<Workout> getWorkouts() {
		return workouts;
	}
	/**
	 * @param workouts the workouts to set
	 */
	public void setWorkouts(Workout workout) {
		this.workouts.add(workout);
	}
	/**
	 * @return the meals
	 */
	public List<Meal> getMeals() {
		return meals;
	}
	/**
	 * @param meals the meals to set
	 */
	public void setMeals(Meal meal) {
		this.meals.add(meal);
	}
	/**
	 * @return the users
	 */
	public List<User> getUsers() {
		return users;
	}
	/**
	 * @param users the users to set
	 */
	public void setUsers(User user) {
		this.users.add(user);
	}
	/**
	 * @return the weights
	 */
	public List<WeightTracker> getWeights() {
		return weights;
	}
	/**
	 * @param weights the weights to set
	 */
	public void setWeights(WeightTracker weight) {
		this.weights.add(weight);
	}
	
}
