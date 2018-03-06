package model;

import java.util.Calendar;

public class WeightTracker {

    private int weight;

    public WeightTracker(){}

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
