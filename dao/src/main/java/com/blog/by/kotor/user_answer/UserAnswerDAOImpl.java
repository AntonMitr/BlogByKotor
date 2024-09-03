package com.blog.by.kotor.user_answer;

import com.blog.by.kotor.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.blog.by.kotor.DAOException.USER_ANSWER_DAO_EXCEPTION;
import static com.blog.by.kotor.DAOException.USER_DAO_EXCEPTION;

public class UserAnswerDAOImpl implements UserAnswerDAO {
    private static final String DELETE = "DELETE FROM user_answer WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM user_answer ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM user_answer WHERE id = ?";
    private static final String FIND_BY_QUESTION_ID = "SELECT * FROM user_answer WHERE question_id = ?";
    private static final String FIND_BY_OPTION_ID = "SELECT * FROM user_answer WHERE option_id = ?";
    private static final String INSERT = "INSERT INTO user_answer (question_id, user_id, option_id, answer_text, created_at) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE user_answer SET question_id = ?, user_id = ?, option_id = ?, answer_text = ?, created_at = ? WHERE id = ?";

    private Connection conn;

    private PreparedStatement ps;

    private ResultSet rs;

    private final UserAnswer userAnswer;

    public UserAnswerDAOImpl(UserAnswer userAnswer) {
        this.userAnswer = userAnswer;
    }

    @Override
    public UserAnswer findById(int id) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                userAnswer.setId(rs.getInt("id"));
                userAnswer.setQuestionId(rs.getInt("question_id"));
                userAnswer.setUserId(rs.getInt("user_id"));
                userAnswer.setOptionId(rs.getInt("option_id"));
                userAnswer.setAnswerText(rs.getString("answer_text"));
                userAnswer.setCreatedAt(rs.getDate("created_at"));
            }
        } catch (SQLException e) {
            try {
                throw new DAOException(USER_ANSWER_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return userAnswer;
    }

    @Override
    public List<UserAnswer> getAll() {
         List<UserAnswer> userAnswerList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                userAnswer.setId(rs.getInt("id"));
                userAnswer.setQuestionId(rs.getInt("question_id"));
                userAnswer.setUserId(rs.getInt("user_id"));
                userAnswer.setOptionId(rs.getInt("option_id"));
                userAnswer.setAnswerText(rs.getString("answer_text"));
                userAnswer.setCreatedAt(rs.getDate("created_at"));
                userAnswerList.add(userAnswer);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(USER_ANSWER_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return userAnswerList;
    }

    @Override
    public int insert(UserAnswer userAnswer) {;
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, userAnswer.getQuestionId());
            ps.setInt(2, userAnswer.getUserId());
            ps.setInt(3, userAnswer.getOptionId());
            ps.setString(4, userAnswer.getAnswerText());
            ps.setDate(5, userAnswer.getCreatedAt());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(USER_ANSWER_DAO_EXCEPTION);
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
    public int update(UserAnswer oldUserAnswer, UserAnswer newUserAnswer) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, newUserAnswer.getQuestionId());
            ps.setInt(2, newUserAnswer.getUserId());
            ps.setInt(3, newUserAnswer.getOptionId());
            ps.setString(4, newUserAnswer.getAnswerText());
            ps.setDate(5, newUserAnswer.getCreatedAt());
            ps.setInt(6, oldUserAnswer.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(USER_ANSWER_DAO_EXCEPTION);
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
    public int delete(UserAnswer userAnswer) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, userAnswer.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(USER_ANSWER_DAO_EXCEPTION);
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
    public List<UserAnswer> findByQuestionId(int questionId) {
        List <UserAnswer> userAnswerList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(FIND_BY_QUESTION_ID);
            ps.setInt(1, questionId);

            rs = ps.executeQuery();
            while (rs.next()) {
                userAnswer.setId(rs.getInt("id"));
                userAnswer.setQuestionId(rs.getInt("question_id"));
                userAnswer.setUserId(rs.getInt("user_id"));
                userAnswer.setOptionId(rs.getInt("option_id"));
                userAnswer.setAnswerText(rs.getString("answer_text"));
                userAnswer.setCreatedAt(rs.getDate("created_at"));
                userAnswerList.add(userAnswer);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(USER_ANSWER_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return userAnswerList;
    }

    @Override
    public List<UserAnswer> findByOptionId(int optionId) {
        List<UserAnswer> userAnswerList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_OPTION_ID);
            ps.setInt(1, optionId);

            rs = ps.executeQuery();
            while (rs.next()) {
                userAnswer.setId(rs.getInt("id"));
                userAnswer.setQuestionId(rs.getInt("question_id"));
                userAnswer.setUserId(rs.getInt("user_id"));
                userAnswer.setOptionId(rs.getInt("option_id"));
                userAnswer.setAnswerText(rs.getString("answer_text"));
                userAnswer.setCreatedAt(rs.getDate("created_at"));
                userAnswerList.add(userAnswer);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(USER_ANSWER_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return userAnswerList;
    }

}
