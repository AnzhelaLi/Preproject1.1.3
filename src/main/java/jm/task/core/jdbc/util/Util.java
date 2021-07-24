package jm.task.core.jdbc.util;

import jm.task.core.jdbc.service.UserServiceImpl;

import java.sql.*;


public class Util {

    private static String DB_DRIVER;
    private static String DB_URL;
    private static String DB_USERNAME;
    private static String DB_PASSWORD;
    private static Util instance;
    private static Connection conn;


    private Util() {

        DB_DRIVER = "com.mysql.jdbc.Driver";
        DB_URL = "jdbc:mysql://localhost:3306/mydb?autoReconnect=true&useSSL=false";
        DB_USERNAME = "root";
        DB_PASSWORD = "Melody305??!";
    }

    public static Util getInstance() {
        if (instance == null) {
            instance = new Util();
        }
        return instance;
    }
    public Connection getConnection() {
        if(conn == null) {
            try {
                Class.forName(DB_DRIVER);
                conn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            } catch(SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return conn;
    }
    public static void closeConnection() throws SQLException {
            conn.close();
    }
}
// реализуйте настройку соеденения с БД


