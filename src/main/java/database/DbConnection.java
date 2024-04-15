package database;

import entities.Load;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DbConnection {

    private Connection conn;

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    public Connection connect() {
        setConn(null);
        try {
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost:5432/controledequalidade", "postgres", "Bmw123bmw");
            setConn(conn);
            if(getConn() != null){
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
            String query = "CREATE TABLE "+tableName+" (invoice INT PRIMARY KEY, plate VARCHAR(10), weight DOUBLE PRECISION, timeLeft VARCHAR(10), timeArrived VARCHAR(10), timeApp VARCHAR(10))";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Table created successfully");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void insertData(Connection conn, String tableName, Load load){
        Statement statement;
        try{
            String query="INSERT INTO "+tableName+" (invoice, plate, weight, timeLeft, timeArrived, timeApp) VALUES ("+load.getInvoice()+", '"+load.getPlate()+"', "+load.getWeight()+", '"+load.getTimeLeft()+"', '"+load.getTimeArrived()+"', '"+load.getTimeApp()+"')";
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data inserted successfully");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void readAllData(Connection conn, String tableName){
        Statement statement;
        ResultSet rs = null;
        try{
            String query = "SELECT * FROM "+tableName;
            statement = conn.createStatement();
            statement.executeQuery(query);
            rs = statement.executeQuery(query);
            while(rs.next()){
                System.out.println("Invoice: "+rs.getInt("invoice")+" Plate: "+rs.getString("plate")+" Weight: "+rs.getDouble("weight")+" Time left: "+rs.getString("timeLeft")+" Time arrived: "+rs.getString("timeArrived")+" Time app: "+rs.getString("timeApp"));
            }

            System.out.println("Data read successfully");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public Load getLoad(Connection conn, int invoice){
        Load load = null;
        Statement statement;
        try{
            String query = "SELECT * FROM loads WHERE invoice="+invoice;
            statement = conn.createStatement();
            statement.executeQuery(query);
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                load = new Load(rs.getInt("invoice"), rs.getString("plate"), rs.getDouble("weight"), rs.getString("timeLeft"), rs.getString("timeArrived"), rs.getString("timeApp"));
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        return load;
    }

    public void updateData(Connection conn, String tableName,  Load oldLoad, Load newLoad){
        Statement statement;
        try{
            String query = "UPDATE "+tableName+" SET invoice="+newLoad.getInvoice()+", plate='"+newLoad.getPlate()+"', weight="+newLoad.getWeight()+", timeLeft='"+newLoad.getTimeLeft()+"', timeArrived='"+newLoad.getTimeArrived()+"', timeApp='"+newLoad.getTimeApp()+"' WHERE invoice="+oldLoad.getInvoice();
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data updated successfully");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void deleteData(Connection conn, String tableName, int invoice){
        Statement statement;
        try{
            String query = "DELETE FROM "+tableName+" WHERE invoice="+invoice;
            statement = conn.createStatement();
            statement.executeUpdate(query);
            System.out.println("Data deleted successfully");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
