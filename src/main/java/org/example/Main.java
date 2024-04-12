package org.example;

import database.DbConnection;
import entities.Load;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        DbConnection db = new DbConnection();
        Connection conn = db.connect();
        db.insertData(conn, "controledequalidade", 323245, "ABC1234");

    }
}