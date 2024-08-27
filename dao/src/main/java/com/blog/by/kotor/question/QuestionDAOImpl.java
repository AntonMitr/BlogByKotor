package com.blog.by.kotor.question;

import com.blog.by.kotor.Question;
import com.blog.by.kotor.Util;

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
    private static final String UPDATE = "UPDATE questions set poll_id = ?, question_text = ? WHERE id = ?";

    @Override
    public Question findById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Question question = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                question = new Question();
                question.setId(rs.getInt("id"));
                question.setPollId(rs.getInt("poll_id"));
                question.setQuestionText(rs.getString("question_text"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return question;
    }

    @Override
    public List<Question> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Question> questionList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setPollId(rs.getInt("poll_id"));
                question.setQuestionText(rs.getString("question_text"));
                questionList.add(question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return questionList;
    }

    @Override
    public int insert(Question question) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, question.getPollId());
            ps.setString(2, question.getQuestionText());

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
    public int update(Question oldQuestion, Question newQuestion) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, newQuestion.getPollId());
            ps.setString(2, newQuestion.getQuestionText());
            ps.setInt(3, oldQuestion.getId());

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
    public int delete(Question question) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, question.getId());

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
    public List<Question> findByPollId(int pollId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Question> questionList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_POLL_ID);
            ps.setInt(1, pollId);

            rs = ps.executeQuery();
            while (rs.next()) {
                Question question = new Question();
                question.setId(rs.getInt("id"));
                question.setPollId(rs.getInt("poll_id"));
                question.setQuestionText(rs.getString("question_text"));
                questionList.add(question);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return questionList;
    }

}
