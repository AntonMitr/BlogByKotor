package com.blog.by.kotor;

import java.sql.*;
import java.util.ResourceBundle;

import static com.blog.by.kotor.DBException.*;

public class DatabaseConnection {

    private static final String DB_DRIVER;

    private static final String DB_URL;

    private static final String DB_USER;

    private static final String DB_PASSWORD;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        DB_DRIVER = rb.getString("db.driver");
        DB_URL = rb.getString("db.url");
        DB_USER = rb.getString("db.user");
        DB_PASSWORD = rb.getString("db.password");
    }

    private DatabaseConnection() {
    }

    public static Connection getConnection() {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            try {
                throw new DBException(DB_NOT_CONNECTED);
            } catch (DBException e) {
                e.getMessage();
            }
        }
        return conn;
    }

    public static void closeConnection(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                try {
                    throw new DBException(CLOSE_CONN_ERROR);
                } catch (DBException ex) {
                    ex.getMessage();
                }
            }
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                try {
                    throw new DBException(CLOSE_PS_ERROR);
                } catch (DBException ex) {
                    ex.getMessage();
                }
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                try {
                    throw new DBException(CLOSE_RS_ERROR);
                } catch (DBException ex) {
                    ex.getMessage();
                }
            }
        }
    }

    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) {
        closeConnection(conn);
        closePreparedStatement(ps);
        closeResultSet(rs);
    }
}
