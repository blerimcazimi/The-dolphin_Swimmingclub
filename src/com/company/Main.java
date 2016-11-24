package com.company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws IOException
    {

        try
        {
            Database database = new Database();
            Connection conn = database.getConnection();

            Statement stmt = conn.createStatement() ;
            String query = "select * from member" ;
            ResultSet rs = stmt.executeQuery(query) ;

            while(rs.next())
            {

                System.out.println(rs.getString("navn"));

            }

        } catch(SQLException a)
        {
            System.out.println("lol");
        }


        Member member = new Member();
        member.login();

        Read r = new Read();

        System.out.println("Vil du se oversigten over alle registrede medllemer (Y/N)?");
        Scanner keyboard = new Scanner(System.in);
        String oversigtAnswer = keyboard.nextLine();


        if(oversigtAnswer.equalsIgnoreCase("Y"))
            r.returnfile();

    }
}