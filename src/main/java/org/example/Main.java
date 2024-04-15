package org.example;

import database.DbConnection;
import entities.Load;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        DbConnection db = new DbConnection();
        Connection conn = db.connect();

        System.out.println("Choose what you wanna do:");
        System.out.println("1 - Get data");
        System.out.println("2 - Insert data");
        System.out.println("3 - Update data");

        int option = sc.nextInt();

        switch (option){
            case 1: {
                db.readAllData(conn, "loads");
                break;
            }
            case 2: {
                Load load = newLoad();
                db.insertData(conn, "loads", load);
                break;
            }
            case 3: {
                System.out.println("Enter the invoice number: ");
                int invoice = sc.nextInt();
                Load oldLoad = db.getLoad(conn, invoice);
                System.out.println("Update your load");
                Load newLoad = newLoad();
                db.updateData(conn, "loads", oldLoad, newLoad);
            }
        }
    }

    public static Load newLoad(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the invoice, plate, weight, timeLeft, timeArrived and timeApp");

        int invoice = sc.nextInt();
        String plate = sc.next();
        double weight = sc.nextDouble();
        String timeLeft = sc.next();
        String timeArrived = sc.next();
        String timeApp = sc.next();

        return new Load(invoice, plate, weight, timeLeft, timeArrived, timeApp);
    }
}