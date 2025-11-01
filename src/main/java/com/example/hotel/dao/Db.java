package com.example.hotel.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Db {
    private static String url = "jdbc:h2:mem:hotel;DB_CLOSE_DELAY=-1";
    private static String user = "sa";
    private static String pass = "";

    public static Connection get() throws SQLException {
        return DriverManager.getConnection(url, user, pass);
    }
}
