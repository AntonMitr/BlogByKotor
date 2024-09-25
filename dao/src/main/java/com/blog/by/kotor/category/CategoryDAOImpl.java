package com.blog.by.kotor.category;

import com.blog.by.kotor.Category;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAOImpl implements CategoryDAO {

    private static final String DELETE = "DELETE FROM categories WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM categories ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM categories WHERE id = ?";
    private static final String FIND_BY_NAME = "SELECT * FROM categories WHERE name = ?";
    private static final String INSERT = "INSERT INTO categories (name) VALUES (?)";
    private static final String UPDATE = "UPDATE categories SET name = ? WHERE id = ?";

    private static CategoryDAO categoryDAO;

    private CategoryDAOImpl() {
    }

    public static CategoryDAO getCategoryDAOImpl() {
        if (categoryDAO == null) {
            categoryDAO = new CategoryDAOImpl();
        }
        return categoryDAO;
    }

    @Override
    public Category findById(int id) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Category category = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.CATEGORY_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return category;
    }

    @Override
    public List<Category> getAll() throws DAOException, DBException{
        List<Category> categoryList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Category category = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
                categoryList.add(category);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.CATEGORY_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return categoryList;
    }

    @Override
    public int insert(Category category) throws DAOException, DBException{
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setString(1, category.getName());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.CATEGORY_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int update(Category oldCategory, Category newCategory) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, newCategory.getName());
            ps.setInt(2, oldCategory.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.CATEGORY_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int delete(Category category) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, category.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.CATEGORY_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public Category findByName(String name) throws DAOException, DBException{
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Category category = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_NAME);
            ps.setString(1, name);

            rs = ps.executeQuery();
            while (rs.next()) {
                category = new Category();
                category.setId(rs.getInt("id"));
                category.setName(rs.getString("name"));
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.CATEGORY_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return category;
    }

}
