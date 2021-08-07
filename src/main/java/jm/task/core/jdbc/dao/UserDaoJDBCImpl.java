package jm.task.core.jdbc.dao;


import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class UserDaoJDBCImpl implements UserDao {

    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "CREATE TABLE IF NOT EXISTS users (id BIGINT not NULL AUTO_INCREMENT, " +
                "name VARCHAR(20), " +
                "lastName VARCHAR(20), " +
                "age INTEGER, " +
                "PRIMARY KEY (id))";
        try {
            connection = Util.getInstance().getCon();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                    System.out.println("PreparedStatement closed successfully");
                }
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed successfully");
                }
            } catch (SQLException e) {
            }
        }
    }

    public void dropUsersTable() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DROP TABLE IF EXISTS users";
        try {
            connection = Util.getInstance().getCon();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                    System.out.println("PreparedStatement closed successfully");
                }
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed successfully");
                }
            } catch (SQLException e) {
            }
        }
    }

    public void saveUser(String name, String lastName, byte age) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "INSERT INTO USERS( NAME, LASTNAME, AGE ) VALUES ( ?, ?, ? ) ";
        try {
            connection = Util.getInstance().getCon();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            preparedStatement.setString(2, lastName);
            preparedStatement.setByte(3, age);
            preparedStatement.executeUpdate();
            System.out.println("User с именем: " + name + " добавлен в базу данных");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                    System.out.println("PreparedStatement closed successfully");
                }
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed successfully");
                }
            } catch (SQLException e) {
            }
        }
    }

    public void removeUserById(long id) {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "DELETE FROM USERS WHERE ID = ?";
        try {
            connection = Util.getInstance().getCon();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                    System.out.println("PreparedStatement closed successfully");
                }
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed successfully");
                }
            } catch (SQLException e) {
            }
        }
    }

    public List<User> getAllUsers() {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        List<User> listOfAllUsers = new ArrayList<>();
        String sql = "SELECT id, name, lastName, age FROM USERS";
        try {
            connection = Util.getInstance().getCon();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
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
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    System.out.println("ResultSet closed successfully");
                }
                if (statement != null) {
                    statement.close();
                    System.out.println("PreparedStatement closed successfully");
                }
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed successfully");
                }
            } catch (SQLException e) {
            }
        }
        return listOfAllUsers;
    }

    public void cleanUsersTable() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        String sql = "TRUNCATE USERS";
        try {
            connection = Util.getInstance().getCon();
            preparedStatement = connection.prepareStatement(sql);
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                    System.out.println("PreparedStatement closed successfully");
                }
                if (connection != null) {
                    connection.close();
                    System.out.println("Connection closed successfully");
                }
            } catch (SQLException e) {
            }
        }
    }
}


