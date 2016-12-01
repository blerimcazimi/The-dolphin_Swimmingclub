package com.company;

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

    public String getMemberName() {
        return memberName;
    }

}