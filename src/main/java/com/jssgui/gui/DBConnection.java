package com.jssgui.gui;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private static Connection con = null;

    static {
        String url = "jdbc:mysql://localhost:3306/monjs";
        String user = "root";
        String pw = "kali";

        try {
            con = DriverManager.getConnection(url, user, pw);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection()
    {
        return con;
    }
}
