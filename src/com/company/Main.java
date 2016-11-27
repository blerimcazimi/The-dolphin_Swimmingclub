package com.company;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Member member = new Member();
        member.loginFuntion();

        /*

        Member member = new Member();
        member.login();

        Read r = new Read();

        System.out.println("Vil du se oversigten over alle registrede medllemer (Y/N)?");
        Scanner keyboard = new Scanner(System.in);
        String oversigtAnswer = keyboard.nextLine();


        if(oversigtAnswer.equalsIgnoreCase("Y"))
        {
            System.out.println("henter medlemmer...");

            try {
                Database database = new Database();
                Connection conn = database.getConnection();

                Statement stmt = conn.createStatement();
                String query = "select * from member ORDER BY member_id DESC";
                ResultSet rs = stmt.executeQuery(query);

                while (rs.next())
                {

                    System.out.println("Medlemns ID: " + rs.getString("member_id"));
                    System.out.println("Medlemns navn: " + rs.getString("navn"));
                    System.out.println("Medlemmets alder: " + rs.getString("alder"));

                    System.out.println("");

                }

            } catch (SQLException a) {
                System.out.println("Kunne ikke hente medlemmer..");
            }

        }

    }*/

    }
}