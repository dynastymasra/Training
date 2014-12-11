/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.squarecode.training.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Dynastymasra
 */
public class DatabaseConnection {
    private static Connection connection;
    private final static String url = "jdbc:mysql://localhost:3306/SQUARECODE_TRAINING";
    private final static String user = "root";
    private final static String pass = "";
    
    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, user, pass);
        } catch( SQLException | ClassNotFoundException ex) {
            System.out.println("Database Connection Failed:" +ex.getMessage());
        }
        return connection;
    }
}
