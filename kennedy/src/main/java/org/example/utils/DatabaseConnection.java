package org.example.utils;

// utils/DatabaseConnection.java
import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/nom_de_ta_base";
    private static final String USER = "root";
    private static final String PASSWORD = "negou1234";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}