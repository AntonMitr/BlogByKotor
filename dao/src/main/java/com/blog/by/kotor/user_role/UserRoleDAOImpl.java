package com.blog.by.kotor.user_role;

import com.blog.by.kotor.UserRole;
import com.blog.by.kotor.Util;

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
    private static final String UPDATE = "UPDATE users_roles set user_id = ?, role_id = ? WHERE user_id = ?";

    @Override
    public UserRole findById(int user_id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserRole userRole = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_USER_ID);
            ps.setInt(1, user_id);

            rs = ps.executeQuery();
            while (rs.next()) {
                userRole = new UserRole();
                userRole.setUserId(rs.getInt("user_id"));
                userRole.setRoleId(rs.getInt("role_id"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return userRole;
    }

    @Override
    public List<UserRole> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserRole> tagList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                UserRole userRole = new UserRole();
                userRole.setRoleId(rs.getInt("user_id"));
                userRole.setUserId(rs.getInt("role_id"));
                tagList.add(userRole);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return tagList;
    }

    @Override
    public int insert(UserRole userRole) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, userRole.getUserId());
            ps.setInt(2, userRole.getRoleId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(conn);
            Util.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public int update(UserRole oldUserRole, UserRole newUserRole) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, newUserRole.getUserId());
            ps.setInt(2, newUserRole.getRoleId());
            ps.setInt(3, oldUserRole.getUserId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(conn);
            Util.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public int delete(UserRole userRole) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, userRole.getUserId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeConnection(conn);
            Util.closePreparedStatement(ps);
        }
        return 0;
    }

}
