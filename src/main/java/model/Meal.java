package model;

public class Meal implements Comparable<Meal> 
{
	private String foodName;
	private int calories;
	private int totalFat;
	private int sodium;
	private int carbs;
	private int protein;
	private int sugar;
	private int satFat;
	private int unsatFat;
	private int cholest;
	private int numServing;
	
	public Meal() {}
	
	/**
	 * @param foodName
	 * @param calories
	 * @param totalFat
	 * @param sodium
	 * @param carbs
	 * @param protein
	 * @param sugar
	 * @param satFat
	 * @param unsatFat
	 * @param cholest
	 * @param numServing
	 */
	public Meal(String foodName, int calories, int totalFat, int satFat, int unsatFat, int sodium, int carbs, int sugar, int cholest, int protein,
				 int numServing)
	{
		this.setFoodName(foodName);
		this.setCalories(calories);
		this.setTotalFat(totalFat);
		this.setSodium(sodium);
		this.setCarbs(carbs);
		this.setProtein(protein);
		this.setSugar(sugar);
		this.setSatFat(satFat);
		this.setUnsatFat(unsatFat);
		this.setCholest(cholest);
		this.setNumServing(numServing);
	}
	
	/**
	 * @return the foodName
	 */
	public String getFoodName() {
		return foodName;
	}
	/**
	 * @param foodName the foodName to set
	 */
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	/**
	 * @return the calories
	 */
	public int getCalories() {
		return calories;
	}
	/**
	 * @param calories the calories to set
	 */
	public void setCalories(int calories) {
		this.calories = calories;
	}
	/**
	 * @return the totalFat
	 */
	public int getTotalFat() {
		return totalFat;
	}
	/**
	 * @param totalFat the totalFat to set
	 */
	public void setTotalFat(int totalFat) {
		this.totalFat = totalFat;
	}
	/**
	 * @return the sodium
	 */
	public int getSodium() {
		return sodium;
	}
	/**
	 * @param sodium the sodium to set
	 */
	public void setSodium(int sodium) {
		this.sodium = sodium;
	}
	/**
	 * @return the carbs
	 */
	public int getCarbs() {
		return carbs;
	}
	/**
	 * @param carbs the carbs to set
	 */
	public void setCarbs(int carbs) {
		this.carbs = carbs;
	}
	/**
	 * @return the protein
	 */
	public int getProtein() {
		return protein;
	}
	/**
	 * @param protein the protein to set
	 */
	public void setProtein(int protein) {
		this.protein = protein;
	}
	/**
	 * @return the sugar
	 */
	public int getSugar() {
		return sugar;
	}
	/**
	 * @param sugar the sugar to set
	 */
	public void setSugar(int sugar) {
		this.sugar = sugar;
	}
	/**
	 * @return the satFat
	 */
	public int getSatFat() {
		return satFat;
	}
	/**
	 * @param satFat the satFat to set
	 */
	public void setSatFat(int satFat) {
		this.satFat = satFat;
	}
	/**
	 * @return the unsatFat
	 */
	public int getUnsatFat() {
		return unsatFat;
	}
	/**
	 * @param unsatFat the unsatFat to set
	 */
	public void setUnsatFat(int unsatFat) {
		this.unsatFat = unsatFat;
	}
	/**
	 * @return the cholest
	 */
	public int getCholest() {
		return cholest;
	}
	/**
	 * @param cholest the cholest to set
	 */
	public void setCholest(int cholest) {
		this.cholest = cholest;
	}
	/**
	 * @return the numServing
	 */
	public int getNumServing() {
		return numServing;
	}
	/**
	 * @param numServing the numServing to set
	 */
	public void setNumServing(int numServing) {
		this.numServing = numServing;
	}
	
	@Override
	public String toString()
	{
		return "Food: " + this.getFoodName() + "\nNumber of Servings: " + this.getNumServing() + "\nCalories: " + this.getCalories() +
				"\nTotal Fat: " + this.getTotalFat() + "\nSaturated Fat: " + this.getSatFat() + 
				"\nUnsaturated Fat: " + this.getUnsatFat() + "\nSodium: " + this.getSodium() + "\nCholesterol" + this.getCholest() + 
				"\nTotal Carbs" + this.getCarbs() + "\nSugar: " + this.getSugar() + "\nProtein:" + this.getProtein();
	}
	
	@Override
	public boolean equals(Object o)
	{
		Meal other = (Meal) o;
		
		return this.getFoodName().equals(other.getFoodName()) && this.getNumServing()==other.getNumServing() &&
				this.getCalories()==other.getCalories() && this.getTotalFat()==other.getTotalFat() &&
				this.getSatFat()==other.getSatFat() && this.getUnsatFat()==other.getUnsatFat() &&
				this.getSodium()==other.getSodium() && this.getCholest()==other.getCholest() &&
				this.getCarbs()==other.getCarbs() && this.getSugar()==other.getSugar() && this.getProtein()==other.getProtein();
	}
	public int compareTo(Meal m) 
	{
		return this.getFoodName().compareTo(m.getFoodName());
	}
	
}
