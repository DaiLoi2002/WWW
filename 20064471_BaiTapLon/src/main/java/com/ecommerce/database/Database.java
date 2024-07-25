package com.ecommerce.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    // JDBC URL, username and password of MySQL server
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/Webbanxe";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345678";

    public Connection getConnection() {
        Connection conn = null;
        try {
	            // Register the MySQL JDBC driver
	            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection
            conn = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
            System.out.println("Connected to the database.");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC driver not found.");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Connection to database failed.");
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String[] args) {
        // Test the getConnection method
        Database database = new Database();
        Connection connection = database.getConnection();
        if (connection != null) {
            // Do something with the connection
            // For example, print metadata about the database
            try {
                System.out.println("Database metadata:");
                System.out.println("Driver name: " + connection.getMetaData().getDriverName());
                System.out.println("Database product version: " + connection.getMetaData().getDatabaseProductVersion());
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    connection.close(); // Close the connection when done
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

