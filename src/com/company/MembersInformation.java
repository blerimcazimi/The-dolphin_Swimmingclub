package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by Thomas on 21-11-2016.
 */
public class MembersInformation {

    private String memberName;
    private int memeberAge;

    public MembersInformation(String name, int age)
    {
        this.memberName = name;
        this.memeberAge = age;

        try
        {
            Database database = new Database();
            Connection conn = database.getConnection();

            Statement stmt = conn.createStatement() ;
            String query = "insert into member SET navn = '" + name + "', alder = '" + age + "'";
            stmt.executeUpdate(query);

        } catch(SQLException a)
        {
            System.out.println("lol");
        }

    }

    public int getMemeberAge() {
        return memeberAge;
    }

    public String getMemberName() {
        return memberName;
    }

}