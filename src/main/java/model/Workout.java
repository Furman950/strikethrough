package model;

import java.io.Serializable;

public class Workout implements Serializable
{

    private static final long serialVersionUID = 1L;

	private int reps;
	private int sets;
	private String name;
	
	public Workout() {}
	
	/**
	 * @param reps
	 * @param sets
	 */
	public Workout(String name, int reps, int sets) {
	    this.setName(name);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
	public String toString()
	{
		return "Name: " + this.getName() + ", Sets: " + this.getSets() + ", Reps: " + this.getReps();
	}
	
	@Override
	public boolean equals(Object o)
	{
		Workout other = (Workout) o;
		
		return this.getSets()==other.getSets() && this.getReps()==other.getReps();
	}
}
