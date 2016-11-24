package com.company;

/**
 * Created by Thomas on 21-11-2016.
 */
public class MembersInformation {

    private String memberName;
    private int memeberAge;

    public MembersInformation(String name, int age) {
        this.memberName = name;
        this.memeberAge = age;
    }

    public int getMemeberAge() {
        return memeberAge;
    }

    public String getMemberName() {
        return memberName;
    }
}