package com.company;

/**
 * Created by blerimcazimi on 27/11/2016.
 */
public class Elitesvømmere{



    private double swimmingTime;
    private String memberName;

    public Elitesvømmere(String name, double records) {
        this.swimmingTime = records;
        this.memberName = name;
    }

    public void setSwimmingTime(double swimmingTime) {
        this.swimmingTime = swimmingTime;
    }

    public double getSwimmingTime() {
        return swimmingTime;
    }
}