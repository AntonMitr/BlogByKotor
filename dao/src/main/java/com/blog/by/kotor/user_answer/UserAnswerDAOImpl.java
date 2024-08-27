package com.blog.by.kotor.user_answer;

import com.blog.by.kotor.UserAnswer;
import com.blog.by.kotor.Util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserAnswerDAOImpl implements UserAnswerDAO {
    private static final String DELETE = "DELETE FROM user_answer WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM user_answer ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM user_answer WHERE id = ?";
    private static final String FIND_BY_QUESTION_ID = "SELECT * FROM user_answer WHERE question_id = ?";
    private static final String FIND_BY_OPTION_ID = "SELECT * FROM user_answer WHERE option_id = ?";
    private static final String INSERT = "INSERT INTO user_answer (question_id, user_id, option_id, answer_text, created_at) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE user_answer set question_id = ?, user_id = ?, option_id = ?, answer_text = ?, created_at = ? WHERE id = ?";

    @Override
    public UserAnswer findById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        UserAnswer userAnswer = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            if (rs.next()) {
                userAnswer = new UserAnswer();
                userAnswer.setId(rs.getInt("id"));
                userAnswer.setQuestionId(rs.getInt("question_id"));
                userAnswer.setUserId(rs.getInt("user_id"));
                userAnswer.setOptionId(rs.getInt("option_id"));
                userAnswer.setAnswerText(rs.getString("answer_text"));
                userAnswer.setCreatedAt(rs.getDate("created_at"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return userAnswer;
    }

    @Override
    public List<UserAnswer> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserAnswer> userAnswerList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                UserAnswer userAnswer = new UserAnswer();
                userAnswer.setId(rs.getInt("id"));
                userAnswer.setQuestionId(rs.getInt("question_id"));
                userAnswer.setUserId(rs.getInt("user_id"));
                userAnswer.setOptionId(rs.getInt("option_id"));
                userAnswer.setAnswerText(rs.getString("answer_text"));
                userAnswer.setCreatedAt(rs.getDate("created_at"));
                userAnswerList.add(userAnswer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return userAnswerList;
    }

    @Override
    public int insert(UserAnswer userAnswer) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, userAnswer.getQuestionId());
            ps.setInt(2, userAnswer.getUserId());
            ps.setInt(3, userAnswer.getOptionId());
            ps.setString(4, userAnswer.getAnswerText());
            ps.setDate(5, userAnswer.getCreatedAt());

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
    public int update(UserAnswer oldUserAnswer, UserAnswer newUserAnswer) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, newUserAnswer.getQuestionId());
            ps.setInt(2, newUserAnswer.getUserId());
            ps.setInt(3, newUserAnswer.getOptionId());
            ps.setString(4, newUserAnswer.getAnswerText());
            ps.setDate(5, newUserAnswer.getCreatedAt());
            ps.setInt(6, oldUserAnswer.getId());

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
    public int delete(UserAnswer userAnswer) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, userAnswer.getId());

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
    public List<UserAnswer> findByQuestionId(int questionId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserAnswer> userAnswerList = new ArrayList<>();

        try {
            conn = Util.getConnection();
            ps = conn.prepareStatement(FIND_BY_QUESTION_ID);
            ps.setInt(1, questionId);

            rs = ps.executeQuery();
            while (rs.next()) {
                UserAnswer userAnswer = new UserAnswer();
                userAnswer.setId(rs.getInt("id"));
                userAnswer.setQuestionId(rs.getInt("question_id"));
                userAnswer.setUserId(rs.getInt("user_id"));
                userAnswer.setOptionId(rs.getInt("option_id"));
                userAnswer.setAnswerText(rs.getString("answer_text"));
                userAnswer.setCreatedAt(rs.getDate("created_at"));
                userAnswerList.add(userAnswer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return userAnswerList;
    }

    @Override
    public List<UserAnswer> findByOptionId(int optionId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserAnswer> userAnswerList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_OPTION_ID);
            ps.setInt(1, optionId);

            rs = ps.executeQuery();
            while (rs.next()) {
                UserAnswer userAnswer = new UserAnswer();
                userAnswer.setId(rs.getInt("id"));
                userAnswer.setQuestionId(rs.getInt("question_id"));
                userAnswer.setUserId(rs.getInt("user_id"));
                userAnswer.setOptionId(rs.getInt("option_id"));
                userAnswer.setAnswerText(rs.getString("answer_text"));
                userAnswer.setCreatedAt(rs.getDate("created_at"));
                userAnswerList.add(userAnswer);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return userAnswerList;
    }

}
