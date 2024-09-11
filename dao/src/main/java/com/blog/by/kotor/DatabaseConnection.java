package com.blog.by.kotor;

import java.sql.*;
import java.util.ResourceBundle;

import static com.blog.by.kotor.DBException.*;

public class DatabaseConnection {

    private static final String DB_DRIVER;
    private static final String DB_URL;
    private static final String DB_USER;
    private static final String DB_PASSWORD;

    private static DatabaseConnection databaseConnection;

    static {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        DB_DRIVER = rb.getString("db.driver");
        DB_URL = rb.getString("db.url");
        DB_USER = rb.getString("db.user");
        DB_PASSWORD = rb.getString("db.password");
    }

    private DatabaseConnection() {
    }

    public static DatabaseConnection getDatabaseConnection() {
        if (databaseConnection == null) {
            databaseConnection = new DatabaseConnection();
        }
        return databaseConnection;
    }

    public static Connection getConnection() throws DBException {
        Connection conn = null;
        try {
            Class.forName(DB_DRIVER);
            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
        } catch (ClassNotFoundException | SQLException ex) {
            throw new DBException(DB_NOT_CONNECTED_TEXT, ex);
        }
        return conn;
    }

    public static void closeConnection(Connection conn) throws DBException {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                throw new DBException(CLOSE_CONN_ERROR_TEXT, ex);
            }
        }
    }

    public static void closePreparedStatement(PreparedStatement ps) throws DBException {
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException ex) {
                throw new DBException(CLOSE_PS_ERROR_TEXT, ex);
            }
        }
    }

    public static void closeResultSet(ResultSet rs) throws DBException {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException ex) {
                throw new DBException(CLOSE_RS_ERROR_TEXT, ex);
            }
        }
    }

    public static void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws DBException {
        closeConnection(conn);
        closePreparedStatement(ps);
        closeResultSet(rs);
    }

}
