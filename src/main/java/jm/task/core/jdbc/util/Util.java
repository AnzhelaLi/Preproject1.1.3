package jm.task.core.jdbc.util;


import java.sql.*;


public class Util {

    private static String DB_DRIVER;
    private static String DB_URL;
    private static String DB_USERNAME;
    private static String DB_PASSWORD;
    private static Connection conn;
    private static Util instance;

    private Util() {
        DB_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/mydb?useSSL=false";
        DB_USERNAME = "root";
        DB_PASSWORD = "Melody305??!";
    }

    public static Util getInstance() {
        try {
            if (instance == null) {
                synchronized (Util.class) {
                    if (instance == null) {
                        instance = new Util();
                    }
                }
                System.out.println("Instance");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return instance;
    }

    public Connection getCon() {
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
// реализуйте настройку соеденения с БД


