package com.blog.by.kotor.filter;

import com.blog.by.kotor.Comment;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.Filter;
import com.blog.by.kotor.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.blog.by.kotor.DAOException.COMMENT_DAO_EXCEPTION;
import static com.blog.by.kotor.DAOException.FILTER_DAO_EXCEPTION;

public class FilterDAOImpl implements FilterDAO {

    private static final String DELETE = "DELETE FROM filters WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM filters ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM filters WHERE id = ?";
    private static final String FIND_BY_CRITERIA = "SELECT * FROM filters WHERE criteria = ?";
    private static final String INSERT = "INSERT INTO filters (name, criteria) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE filters SET name = ?, criteria = ? WHERE id = ?";

    private Connection conn;

    private PreparedStatement ps;

    private ResultSet rs;

    private final Filter filter;

    public FilterDAOImpl(Filter filter) {
         this.filter = filter;
    }

    @Override
    public Filter findById(int id) {

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(FIND_BY_ID);

            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                filter.setId(rs.getInt("id"));
                filter.setName(rs.getString("name"));
                filter.setCriteria(rs.getString("criteria"));
            }
        } catch (SQLException e) {
            try {
                throw new DAOException(FILTER_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return filter;
    }

    @Override
    public List<Filter> getAll() {
        List<Filter> filterList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                filter.setId(rs.getInt("id"));
                filter.setName(rs.getString("name"));
                filter.setCriteria(rs.getString("criteria"));
                filterList.add(filter);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(FILTER_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return filterList;
    }

    @Override
    public int insert(Filter filter) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setString(1, filter.getName());
            ps.setString(2, filter.getCriteria());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(FILTER_DAO_EXCEPTION);
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
    public int update(Filter oldFilter, Filter newFilter) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setString(1, newFilter.getName());
            ps.setString(2, newFilter.getCriteria());
            ps.setInt(3, oldFilter.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(FILTER_DAO_EXCEPTION);
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
    public int delete(Filter filter) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, filter.getId());
            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(FILTER_DAO_EXCEPTION);
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
    public Filter findByCriteria(String criteria) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_CRITERIA);
            ps.setString(1, criteria);

            rs = ps.executeQuery();
            while (rs.next()) {
                filter.setId(rs.getInt("id"));
                filter.setName(rs.getString("name"));
                filter.setCriteria(rs.getString("criteria"));
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(FILTER_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return filter;
    }

}
