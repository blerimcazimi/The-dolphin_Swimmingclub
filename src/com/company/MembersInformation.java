package com.company;


import java.util.Date;


public class MembersInformation {

    private String memberName;
    private int memeberAge;
    private Date date;
    private String membershipType;

    public MembersInformation(String name, int age, String type, Date d)
    {
        this.memberName = name;
        this.memeberAge = age;
        this.membershipType = type;
        this.date = d;
    }

    public int getMemeberAge() {
        return memeberAge;
    }

    public String getMemberName() {
        return memberName;
    }


    public String getMembershipType() {
        return membershipType;
    }


}