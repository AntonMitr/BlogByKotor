package com.blog.by.kotor.category;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DatabaseConnection;
import com.blog.by.kotor.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.blog.by.kotor.DAOException.CATEGORY_DAO_EXCEPTION;

public class CategoryDAOImpl implements CategoryDAO {

    private static final String DELETE = "DELETE FROM categories WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM categories ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM categories WHERE id = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM categories WHERE name = ?";
    private static final String INSERT = "INSERT INTO categories (name) VALUES (?)";
    private static final String UPDATE = "UPDATE categories SET name = ? WHERE id = ?";

    private Connection conn;

    private PreparedStatement ps;

    private ResultSet rs;

    private final Category category;

    public CategoryDAOImpl(Category category) {
        this.category = category;
    }

    @Override
    public Category findById(int id) {

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
            }
        } catch (SQLException e) {
            try {
                throw new DAOException(CATEGORY_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return category;
    }

    @Override
    public List<Category> getAll() {
        List<Category> categoryList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categoryList.add(category);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(CATEGORY_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return categoryList;
    }

    @Override
    public int insert(Category category) {

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setString(1, category.getName());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(CATEGORY_DAO_EXCEPTION);
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
    public int update(Category oldCategory, Category newCategory) {

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, newCategory.getName());
            ps.setInt(2, oldCategory.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(CATEGORY_DAO_EXCEPTION);
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
    public int delete(Category category) {

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, category.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(CATEGORY_DAO_EXCEPTION);
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
    public Category findByName(String name) {

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_NAME);
            ps.setString(1, name);

            rs = ps.executeQuery();
            while (rs.next()) {
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(CATEGORY_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return category;
    }

}
