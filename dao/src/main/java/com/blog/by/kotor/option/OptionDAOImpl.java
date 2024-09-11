package com.blog.by.kotor.option;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.DatabaseConnection;
import com.blog.by.kotor.Option;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OptionDAOImpl implements OptionDAO {

    private static final String DELETE = "DELETE FROM options WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM options ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM options WHERE id = ?";
    private static final String FIND_BY_QUESTION_ID = "SELECT * FROM options WHERE question_id = ?";
    private static final String INSERT = "INSERT INTO options (question_id, option_text) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE options SET question_id = ?, option_text = ? WHERE id = ?";

    private static OptionDAO optionDAO;

    private OptionDAOImpl() {
    }

    public static OptionDAO getOptionDAOImpl() {
        if (optionDAO == null) {
            optionDAO = new OptionDAOImpl();
        }
        return optionDAO;
    }

    @Override
    public Option findById(int id) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Option option = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                option = new Option();
                option.setId(rs.getInt("id"));
                option.setQuestionId(rs.getInt("question_id"));
                option.setOptionText(rs.getString("option_text"));
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.OPTION_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return option;
    }

    @Override
    public List<Option> getAll() throws DAOException, DBException {
        List<Option> optionList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Option option = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                option = new Option();
                option.setId(rs.getInt("id"));
                option.setQuestionId(rs.getInt("question_id"));
                option.setOptionText(rs.getString("option_text"));
                optionList.add(option);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.OPTION_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return optionList;
    }

    @Override
    public int insert(Option option) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);

            ps.setInt(1, option.getQuestionId());
            ps.setString(2, option.getOptionText());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.OPTION_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int update(Option oldOption, Option newOption) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, newOption.getQuestionId());
            ps.setString(2, newOption.getOptionText());
            ps.setInt(3, oldOption.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.OPTION_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int delete(Option option) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, option.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.OPTION_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public List<Option> findOptionByQuestionId(int questionId) throws DAOException, DBException {
        List<Option> optionList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Option option = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_QUESTION_ID);
            ps.setInt(1, questionId);

            rs = ps.executeQuery();
            while (rs.next()) {
                option = new Option();
                option.setId(rs.getInt("id"));
                option.setQuestionId(rs.getInt("question_id"));
                option.setOptionText(rs.getString("option_text"));
                optionList.add(option);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.OPTION_DAO_EXCEPTION_TEXT, ex);
        }
        return optionList;
    }

}
