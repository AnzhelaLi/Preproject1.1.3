package jm.task.core.jdbc;

import jm.task.core.jdbc.service.UserServiceImpl;
import jm.task.core.jdbc.util.Util;

import java.sql.SQLException;


public class Main {
    public static void main(String[] args) throws SQLException {
        UserServiceImpl u = new UserServiceImpl();
        u.dropUsersTable();
        u.createUsersTable();
        u.saveUser("Tim", "John", (byte) 27);
        u.saveUser("Tom", "Smith", (byte) 70);
        u.saveUser("Yelena", "John", (byte) 24);
        u.saveUser("Kate", "Joly", (byte) 99);

        System.out.println(u.getAllUsers().toString());

        u.cleanUsersTable();

    }
}
