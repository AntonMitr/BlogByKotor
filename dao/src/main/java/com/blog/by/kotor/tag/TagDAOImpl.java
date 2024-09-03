package com.blog.by.kotor.tag;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.PremiumSubscription;
import com.blog.by.kotor.Tag;
import com.blog.by.kotor.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.blog.by.kotor.DAOException.ROLE_DAO_EXCEPTION;
import static com.blog.by.kotor.DAOException.TAG_DAO_EXCEPTION;

public class TagDAOImpl implements TagDAO {
    private static final String DELETE = "DELETE FROM tags WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM tags ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM tags WHERE id = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM tags WHERE name = ?";
    private static final String INSERT = "INSERT INTO tags (name) VALUES (?)";
    private static final String UPDATE = "UPDATE tags SET name = ? WHERE id = ?";

    private Connection conn;

    private PreparedStatement ps;

    private ResultSet rs;

    private final Tag tag;

    public TagDAOImpl(Tag tag) {
        this.tag = tag;
    }

    @Override
    public Tag findById(int id) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                tag.setId(rs.getInt("id"));
                tag.setName(rs.getString("name"));
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(TAG_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return tag;
    }

    @Override
    public List<Tag> getAll() {
        List<Tag> tagList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                tag.setId(rs.getInt("id"));
                tag.setName(rs.getString("name"));
                tagList.add(tag);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(TAG_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return tagList;
    }

    @Override
    public int insert(Tag tag) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setString(1, tag.getName());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(TAG_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public int update(Tag oldTag, Tag newTag) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, newTag.getName());
            ps.setInt(2, oldTag.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(TAG_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public int delete(Tag tag) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, tag.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(TAG_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public Tag findByName(String name) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_NAME);
            ps.setString(1, name);

            rs = ps.executeQuery();
            while (rs.next()) {
                tag.setId(rs.getInt("id"));
                tag.setName(rs.getString("name"));
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(TAG_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return tag;
    }

}
