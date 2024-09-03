package com.blog.by.kotor.poll;

import com.blog.by.kotor.Comment;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.Poll;
import com.blog.by.kotor.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.blog.by.kotor.DAOException.FILTER_DAO_EXCEPTION;
import static com.blog.by.kotor.DAOException.POLL_DAO_EXCEPTION;

public class PollDAOImpl implements PollDAO {

    private static final String DELETE = "DELETE FROM polls WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM polls ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM polls WHERE id = ?";
    private static final String INSERT = "INSERT INTO polls (user_id, title, description, created_at) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE polls SET user_id = ?, title = ?, description = ?, created_at = ? WHERE id = ?";

    private Connection conn;

    private PreparedStatement ps;

    private ResultSet rs;

    private final Poll poll;

    public PollDAOImpl(Poll poll) {
        this.poll = poll;
    }

    @Override
    public Poll findById(int id) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                poll.setId(rs.getInt("id"));
                poll.setUserId(rs.getInt("user_id"));
                poll.setTitle(rs.getString("title"));
                poll.setDescription(rs.getString("description"));
                poll.setCreatedAt(rs.getDate("created_at"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return poll;
    }

    @Override
    public List<Poll> getAll() {
        List<Poll> pollList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                poll.setId(rs.getInt("id"));
                poll.setUserId(rs.getInt("user_id"));
                poll.setTitle(rs.getString("title"));
                poll.setDescription(rs.getString("description"));
                poll.setCreatedAt(rs.getDate("created_at"));
                pollList.add(poll);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(POLL_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return pollList;
    }

    @Override
    public int insert(Poll poll) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, poll.getUserId());
            ps.setString(2, poll.getTitle());
            ps.setString(3, poll.getDescription());
            ps.setDate(4, poll.getCreatedAt());

            return ps.executeUpdate();
        } catch (SQLException e) {
            try {
                throw new DAOException(POLL_DAO_EXCEPTION);
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
    public int update(Poll oldPoll, Poll newPoll) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, newPoll.getUserId());
            ps.setString(2, newPoll.getTitle());
            ps.setString(3, newPoll.getDescription());
            ps.setDate(4, newPoll.getCreatedAt());
            ps.setInt(5, oldPoll.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(POLL_DAO_EXCEPTION);
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
    public int delete(Poll poll) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, poll.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(POLL_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
        return 0;
    }

}
