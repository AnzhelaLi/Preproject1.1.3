package jm.task.core.jdbc.util;

import java.sql.*;

public class CloseConnection {
    public void free(PreparedStatement ps, Connection connect) {
        try {
            if (ps != null) {
                ps.close();
            }
        } catch (SQLException e) {
            System.out.println("PS closes an exception ..");
        } finally {
            if (connect != null) {
                try {
                    connect.close();
                    System.out.println("Connection closed successfully");
                } catch (SQLException e) {
                    System.out.println("connection closes an exception...");
                }
            }
        }
    }

    public void free(ResultSet rs, Statement statement, Connection connect) {
        try {
            if (rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            System.out.println("ResultSet closes an exception ..");
        } finally {
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException e) {
                    System.out.println("PreparedStatement closes an exception...");
                } finally {
                    if (connect != null) {
                        try {
                            connect.close();
                            System.out.println("Connection closed successfully");
                        } catch (SQLException e) {
                            System.out.println("connection closes an exception ..");
                        }
                    }
                }
            }
        }
    }
}
