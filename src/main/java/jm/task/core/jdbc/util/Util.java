package jm.task.core.jdbc.util;

import java.sql.*;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.Executor;

public class Util {

    private static final String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mydb";
    private static final String DB_USERNAME = "root";
    private static final String DB_PASSWORD = "Melody305??!";
    private static Connection jdbcConn;

    static {
        try {
            Class.forName(DB_DRIVER);
            jdbcConn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
            System.out.println("Connected");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getJdbcConn() {
        return jdbcConn;
    }
}

// реализуйте настройку соеденения с БД


