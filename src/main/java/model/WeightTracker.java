package model;

import java.io.Serializable;
import java.util.Calendar;

public class WeightTracker implements Serializable{

    private static final long serialVersionUID = 1L;

    private int weight;

    public WeightTracker(int weight) {
        this.setWeight(weight);
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String toString() {
        return "Weight: " + getWeight();
    }
}
