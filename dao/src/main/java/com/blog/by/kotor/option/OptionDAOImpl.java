package com.blog.by.kotor.option;

import com.blog.by.kotor.Comment;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.Option;
import com.blog.by.kotor.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.blog.by.kotor.DAOException.FILTER_DAO_EXCEPTION;
import static com.blog.by.kotor.DAOException.OPTION_DAO_EXCEPTION;

public class OptionDAOImpl implements OptionDAO {

    private static final String DELETE = "DELETE FROM options WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM options ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM options WHERE id = ?";
    private static final String FIND_BY_QUESTION_ID = "SELECT * FROM options WHERE question_id = ?";
    private static final String INSERT = "INSERT INTO options (question_id, option_text) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE options SET question_id = ?, option_text = ? WHERE id = ?";

    private Connection conn;

    private PreparedStatement ps;

    private ResultSet rs;

    private final Option option;

    public OptionDAOImpl(Option option) {
        this.option = option;
    }

    @Override
    public Option findById(int id) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                option.setId(rs.getInt("id"));
                option.setQuestionId(rs.getInt("question_id"));
                option.setOptionText(rs.getString("option_text"));
            }
        } catch (SQLException e) {
            try {
                throw new DAOException(OPTION_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return option;
    }

    @Override
    public List<Option> getAll() {
        List<Option> optionList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                option.setId(rs.getInt("id"));
                option.setQuestionId(rs.getInt("question_id"));
                option.setOptionText(rs.getString("option_text"));
                optionList.add(option);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(OPTION_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return optionList;
    }

    @Override
    public int insert(Option option) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);

            ps.setInt(1, option.getQuestionId());
            ps.setString(2, option.getOptionText());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(OPTION_DAO_EXCEPTION);
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
    public int update(Option oldOption, Option newOption) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, newOption.getQuestionId());
            ps.setString(2, newOption.getOptionText());
            ps.setInt(3, oldOption.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(OPTION_DAO_EXCEPTION);
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
    public int delete(Option option) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, option.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(OPTION_DAO_EXCEPTION);
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
    public List<Option> findOptionByQuestionId(int questionId) {
        List<Option> optionList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_QUESTION_ID);
            ps.setInt(1, questionId);

            rs = ps.executeQuery();
            while (rs.next()) {
                option.setId(rs.getInt("id"));
                option.setQuestionId(rs.getInt("question_id"));
                option.setOptionText(rs.getString("option_text"));
                optionList.add(option);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(OPTION_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        }
        return optionList;
    }

}
