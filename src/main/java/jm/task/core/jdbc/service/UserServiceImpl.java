package jm.task.core.jdbc.service;

import jm.task.core.jdbc.dao.UserDaoJDBCImpl;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {
    UserDaoJDBCImpl jdbcMethods = new UserDaoJDBCImpl();

    public void createUsersTable() {
        jdbcMethods.createUsersTable();
    }

    public void dropUsersTable() {
        jdbcMethods.dropUsersTable();
    }

    public void saveUser(String name, String lastName, byte age) {
        jdbcMethods.saveUser(name, lastName, age);
    }

    public void removeUserById(long id) {
        jdbcMethods.removeUserById(id);
    }

    public List<User> getAllUsers() {
        return jdbcMethods.getAllUsers();
    }

    public void cleanUsersTable() {
        jdbcMethods.cleanUsersTable();
    }
}
