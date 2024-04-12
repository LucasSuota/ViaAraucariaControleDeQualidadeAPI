package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "Bmw123bmw");
            if(conn != null){
                System.out.println("Connected to the database");
            } else {
                System.out.println("Failed to connect to the database");
            }
        } catch (java.sql.SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }
}
