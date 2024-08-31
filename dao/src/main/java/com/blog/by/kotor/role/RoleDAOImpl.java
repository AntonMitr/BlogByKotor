package com.blog.by.kotor.role;

import com.blog.by.kotor.PremiumSubscription;
import com.blog.by.kotor.Role;
import com.blog.by.kotor.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RoleDAOImpl implements RoleDAO {

    private static final String DELETE = "DELETE FROM roles WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM roles ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM roles WHERE id = ?";
    private static final String INSERT = "INSERT INTO roles (name) VALUES (?)";
    private static final String UPDATE = "UPDATE roles SET name = ? WHERE id = ?";

    private Connection conn;

    private PreparedStatement ps;

    private ResultSet rs;

    private final Role role;

    private List<Role> roleList;

    public RoleDAOImpl() {
        role = new Role();
    }

    @Override
    public Role findById(int id) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return role;
    }

    @Override
    public List<Role> getAll() {
        roleList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);
            rs = ps.executeQuery();

            while (rs.next()) {
                role.setId(rs.getInt("id"));
                role.setName(rs.getString("name"));
                roleList.add(role);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return roleList;
    }

    @Override
    public int insert(Role role) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setString(1, role.getName());

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
    public int update(Role oldRole, Role newRole) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);

            ps.setString(1, newRole.getName());
            ps.setInt(2, oldRole.getId());

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
    public int delete(Role role) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, role.getId());

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
