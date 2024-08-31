package com.blog.by.kotor.user_role;

import com.blog.by.kotor.PremiumSubscription;
import com.blog.by.kotor.UserRole;
import com.blog.by.kotor.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDAOImpl implements UserRoleDAO {

    private static final String DELETE = "DELETE FROM users_roles WHERE user_id = ?";
    private static final String FIND_ALL = "SELECT * FROM users_rols";
    private static final String FIND_BY_USER_ID = "SELECT * FROM users_roles WHERE user_id = ?";
    private static final String INSERT = "INSERT INTO users_roles (user_id, role_id) VALUES (?,?)";
    private static final String UPDATE = "UPDATE users_roles SET user_id = ?, role_id = ? WHERE user_id = ?";

    private Connection conn;

    private PreparedStatement ps;

    private ResultSet rs;

    private final UserRole userRole;

    private List<UserRole> userRoleList;

    public UserRoleDAOImpl() {
        userRole = new UserRole();
    }

    @Override
    public UserRole findById(int user_id) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_USER_ID);
            ps.setInt(1, user_id);

            rs = ps.executeQuery();
            while (rs.next()) {
                userRole.setUserId(rs.getInt("user_id"));
                userRole.setRoleId(rs.getInt("role_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return userRole;
    }

    @Override
    public List<UserRole> getAll() {
        userRoleList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                userRole.setRoleId(rs.getInt("user_id"));
                userRole.setUserId(rs.getInt("role_id"));
                userRoleList.add(userRole);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return userRoleList;
    }

    @Override
    public int insert(UserRole userRole) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, userRole.getUserId());
            ps.setInt(2, userRole.getRoleId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public int update(UserRole oldUserRole, UserRole newUserRole) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, newUserRole.getUserId());
            ps.setInt(2, newUserRole.getRoleId());
            ps.setInt(3, oldUserRole.getUserId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public int delete(UserRole userRole) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, userRole.getUserId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
        return 0;
    }

}
