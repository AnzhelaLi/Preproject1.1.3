package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl u = new UserServiceImpl();

        u.createUsersTable();
        u.saveUser("Tim", "John", (byte) 27);
        u.saveUser("Tom", "Smith", (byte) 70);
        u.saveUser("Yelena", "John", (byte) 24);
        u.saveUser("Kate", "Joly", (byte) 9);

        System.out.println(u.getAllUsers().toString());

        u.cleanUsersTable();
        u.dropUsersTable();
        try {
            Util.getJdbcConn().close();
        } catch (SQLException throwables) {
            if (Util.getJdbcConn() == null) {
                Util.getJdbcConn().close();
            }
            throwables.printStackTrace();
        }
        // реализуйте алгоритм здесь
        if (Util.getJdbcConn() == null) {
            System.out.println("Connection closed");
        }
    }
}
