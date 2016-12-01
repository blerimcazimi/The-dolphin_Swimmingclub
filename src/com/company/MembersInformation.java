package com.company;


import java.util.Date;


public class MembersInformation {

    private String memberName;
    private int memeberAge;
    private Date date;
    private String membershipType;
    private String membersCpr;

    public MembersInformation(String name, int age, String membersCpr, String type, Date d)
    {
        this.memberName = name;
        this.memeberAge = age;
        this.membershipType = type;
        this.membersCpr = membersCpr;
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

    public String getMemberCpr() { return membersCpr; }


}