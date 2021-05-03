package com.employee;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Enumeration;
/*
 *@Description:-create a payroll service database and have java program connect to database
 */
public class DBDemo {
    public static void main(String[] args) throws ClassNotFoundException {
        String jdbcURL = "jdbc:mysql://localhost:3306/payroll_service";
        String userName = "root";
        String password = "Deva@8824264173";
        Connection connection;

        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver loaded!");

        listDrivers();
        try{
            System.out.println("Connecting to database:" +jdbcURL);
            connection = DriverManager.getConnection(jdbcURL, userName, password);
            System.out.println("Connection is successful!!!!"+connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void listDrivers() {
        Enumeration<Driver> driverList = DriverManager.getDrivers();
        while (driverList.hasMoreElements()){
            Driver driverClass = (Driver) driverList.nextElement();
            System.out.println(" "+driverClass.getClass().getName());
        }
    }
}