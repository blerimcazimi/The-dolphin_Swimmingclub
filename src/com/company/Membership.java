package com.company;


import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Membership
{

    public Membership(int member_id)
    {

        try
        {
            Database database = new Database();
            Connection conn = database.getConnection();

            Statement stmt = conn.createStatement() ;
            String query = "insert into membership SET member_id = '" + member_id + "'";
            stmt.executeUpdate(query);

        } catch(SQLException a)
        {
            System.out.println("Kunne ikke oprette membership....");
        }

    }

}
