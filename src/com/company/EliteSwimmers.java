package com.company;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by jakob on 01-12-2016.
 */
public class EliteSwimmers extends  MembersInformation{

    public EliteSwimmers(String name, int age, String type, String membershipAc, String cpr, Date d, String swimresult) {
        super(name, age, type, membershipAc, cpr, d);
        this.Swimresult = swimresult;
    }

    public String getSwimresult() {
        return Swimresult;
    }

    private String Swimresult;

}
