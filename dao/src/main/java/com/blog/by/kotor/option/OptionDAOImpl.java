package com.blog.by.kotor.option;

import com.blog.by.kotor.Option;
import com.blog.by.kotor.Util;

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
    private static final String UPDATE = "UPDATE options set question_id = ?, option_text = ? WHERE id = ?";

    @Override
    public Option findById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Option option = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                option = new Option();
                option.setId(rs.getInt("id"));
                option.setQuestionId(rs.getInt("question_id"));
                option.setOptionText(rs.getString("option_text"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return option;
    }

    @Override
    public List<Option> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Option> optionList = new ArrayList<Option>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                Option option = new Option();
                option.setId(rs.getInt("id"));
                option.setQuestionId(rs.getInt("question_id"));
                option.setOptionText(rs.getString("option_text"));
                optionList.add(option);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return optionList;
    }

    @Override
    public int insert(Option option) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(INSERT);

            ps.setInt(1, option.getQuestionId());
            ps.setString(2, option.getOptionText());

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
    public int update(Option oldOption, Option newOption) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, newOption.getQuestionId());
            ps.setString(2, newOption.getOptionText());
            ps.setInt(3, oldOption.getId());

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
    public int delete(Option option) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, option.getId());

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
    public List<Option> findOptionByQuestionId(int questionId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Option> optionList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_QUESTION_ID);
            ps.setInt(1, questionId);

            rs = ps.executeQuery();
            while (rs.next()) {
                Option option = new Option();
                option.setId(rs.getInt("id"));
                option.setQuestionId(rs.getInt("question_id"));
                option.setOptionText(rs.getString("option_text"));
                optionList.add(option);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return optionList;
    }

}
