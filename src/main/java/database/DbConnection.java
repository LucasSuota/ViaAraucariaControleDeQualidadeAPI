package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DbConnection {
    public Connection connect() {
        Connection conn = null;
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/controledequalidade", "postgres", "Bmw123bmw");
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

    public void createTable(Connection conn, String tableName){
        Statement statement;
        try{
            String query="CREATE TABLE "+tableName+" (invoice INT PRIMARY KEY, plate VARCHAR(255))";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created successfully");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void insertData(Connection conn, String tableName, int invoice, String plate){
        Statement statement;
        try{
            String query="INSERT INTO "+tableName+" (invoice, plate) VALUES ("+invoice+", '"+plate+"')";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data inserted successfully");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
