package model;

public class CustomWorkout extends Workout 
{

	private String name;

	public CustomWorkout() {}
	
	public CustomWorkout(int reps, int sets, String name) 
	{
		super(reps, sets);
		this.setName(name);
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString()
	{
		return "Name of Workout: " + this.getName() + "\n" + super.toString();
	}
	
	@Override
	public boolean equals(Object o)
	{
		CustomWorkout other = (CustomWorkout) o;
		
		return super.equals(other) && this.getName().equals(other.getName());
	}
}
