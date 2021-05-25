package jm.task.core.jdbc.service;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    Connection conn = Util.getJdbcConn();

    public void createUsersTable() {
        PreparedStatement ps;
        String sql = "CREATE TABLE IF NOT EXISTS users (id BIGINT not NULL AUTO_INCREMENT, " +
                "name VARCHAR(20), " +
                "lastName VARCHAR(20), " +
                "age INTEGER, " +
                "PRIMARY KEY (id))";
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void dropUsersTable() {
        PreparedStatement ps;
        String sql = "DROP TABLE IF EXISTS users";
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void saveUser(String name, String lastName, byte age) {

        PreparedStatement ps;
        String sql = "INSERT INTO users ( name, lastName, age ) VALUES ( ?, ?, ? ) ";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, name);
            ps.setString(2, lastName);
            ps.setByte(3, age);
            ps.execute();
            System.out.println("User с именем: " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removeUserById(long id) {
        PreparedStatement ps = null;
        String sql = "DELETE FROM users WHERE id = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setLong(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {

        List<User> listOfAllUsers = new ArrayList<>();
        String sql = "SELECT id, name, lastName, age FROM USERS";
        Statement statement = null;
        try {
            statement = Util.getJdbcConn().createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getLong("id"));
                user.setName(resultSet.getString("name"));
                user.setLastName(resultSet.getString("lastName"));
                user.setAge(resultSet.getByte("age"));
                listOfAllUsers.add(user);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return listOfAllUsers;
    }

    public void cleanUsersTable() {
        String sql = "truncate table users";
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(sql);
            ps.execute();
            getAllUsers();
            int numberOfUsers = getAllUsers().size();
            if (numberOfUsers == 0) {
                System.out.println("Deleted all rows in the table successfully");
            } else {
                System.out.println("Что-то пошло не так");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
