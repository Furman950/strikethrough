package model;

public class User {
	
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
	 * @return the user
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param user the user to set
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
	
	/**
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	
	@Override
	public boolean equals(Object obj) {
		User user = (User) obj;
		return this.getUsername() == user.getUsername();
	}
	
	

}
