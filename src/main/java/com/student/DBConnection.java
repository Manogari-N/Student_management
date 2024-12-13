package com.student;

import java.sql.*;

public class DBConnection {
    public static Connection getConnection() throws SQLException {
        String url = "jdbc:postgresql://localhost:5432/studentdb";
        String user = "postgres";
        String password = "mano";
        return DriverManager.getConnection(url, user, password);
    }
}
