package model;

public class Workout 
{
	private int reps;
	private int sets;
	
	public Workout() {}
	
	/**
	 * @param reps
	 * @param sets
	 */
	public Workout(int reps, int sets) {
		super();
		this.setReps(reps);
		this.setSets(sets);
	}
	/**
	 * @return the reps
	 */
	public int getReps() {
		return reps;
	}
	/**
	 * @param reps the reps to set
	 */
	public void setReps(int reps) {
		this.reps = reps;
	}
	/**
	 * @return the sets
	 */
	public int getSets() {
		return sets;
	}
	/**
	 * @param sets the sets to set
	 */
	public void setSets(int sets) {
		this.sets = sets;
	}
	
	@Override
	public String toString()
	{
		return "Sets: " + this.getSets() + "\nReps: " + this.getReps();
	}
	
	@Override
	public boolean equals(Object o)
	{
		Workout other = (Workout) o;
		
		return this.getSets()==other.getSets() && this.getReps()==other.getReps();
	}
}
