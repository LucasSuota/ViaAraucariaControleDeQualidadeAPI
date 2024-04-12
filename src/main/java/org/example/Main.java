package org.example;

import database.DbConnection;
import entities.Load;
public class Main {
    public static void main(String[] args) {
        DbConnection db = new DbConnection();
        db.connect();
    }
}