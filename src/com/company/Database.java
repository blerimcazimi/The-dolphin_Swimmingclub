package com.company;

import java.sql.Connection;

import java.sql.*;

public class Database {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://healthscore.dk/healthsc_eksamen";

    //  Database credentials
    static final String USER = "healthsc_eksamen";
    static final String PASS = "dat16b";

    //...
    public static Connection conn;
    public static Statement stmt;

    public Connection getConnection() throws SQLException
    {

        try {
            //STEP 2: Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //STEP 3: Open a connection
            //System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            return conn;

        } catch(ClassNotFoundException exception)
        {
            System.out.println("JDBC driver skal installeres.");
        }

        return conn;

    }

}

