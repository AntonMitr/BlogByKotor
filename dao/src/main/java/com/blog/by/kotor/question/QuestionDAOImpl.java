package com.blog.by.kotor.question;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.DatabaseConnection;
import com.blog.by.kotor.Question;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class QuestionDAOImpl implements QuestionDAO {
    private static final String DELETE = "DELETE FROM questions WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM questions ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM questions WHERE id = ?";
    private static final String FIND_BY_POLL_ID = "SELECT * FROM questions WHERE poll_id = ?";
    private static final String INSERT = "INSERT INTO questions (poll_id, question_text) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE questions SET poll_id = ?, question_text = ? WHERE id = ?";

    private static QuestionDAO questionDAO;

    private QuestionDAOImpl() {
    }

    public static QuestionDAO getQuestionDAOImpl() {
        if (questionDAO == null) {
            questionDAO = new QuestionDAOImpl();
        }
        return questionDAO;
    }

    @Override
    public Question findById(int id) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Question question = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setPollId(rs.getInt("poll_id"));
                question.setQuestionText(rs.getString("question_text"));
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.QUESTION_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return question;
    }

    @Override
    public List<Question> getAll() throws DAOException, DBException {
        List<Question> questionList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Question question = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setPollId(rs.getInt("poll_id"));
                question.setQuestionText(rs.getString("question_text"));
                questionList.add(question);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.QUESTION_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return questionList;
    }

    @Override
    public int insert(Question question) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, question.getPollId());
            ps.setString(2, question.getQuestionText());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.QUESTION_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int update(Question oldQuestion, Question newQuestion) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, newQuestion.getPollId());
            ps.setString(2, newQuestion.getQuestionText());
            ps.setInt(3, oldQuestion.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.QUESTION_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int delete(Question question) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, question.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.QUESTION_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public List<Question> findByPollId(int pollId) throws DAOException, DBException {
        List<Question> questionList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Question question = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_POLL_ID);
            ps.setInt(1, pollId);

            rs = ps.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setPollId(rs.getInt("poll_id"));
                question.setQuestionText(rs.getString("question_text"));
                questionList.add(question);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.QUESTION_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return questionList;
    }

}
