package com.blog.by.kotor.poll;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.DatabaseConnection;
import com.blog.by.kotor.Poll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PollDAOImpl implements PollDAO {

    private static final String DELETE = "DELETE FROM polls WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM polls ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM polls WHERE id = ?";
    private static final String INSERT = "INSERT INTO polls (user_id, title, description, created_at) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE polls SET user_id = ?, title = ?, description = ?, created_at = ? WHERE id = ?";

    private static PollDAO pollDAO;

    private PollDAOImpl() {
    }

    public static PollDAO getPollDAOImpl() {
        if (pollDAO == null) {
            pollDAO = new PollDAOImpl();
        }
        return pollDAO;
    }

    @Override
    public Poll findById(int id) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Poll poll = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                poll = new Poll();
                poll.setId(rs.getInt("id"));
                poll.setUserId(rs.getInt("user_id"));
                poll.setTitle(rs.getString("title"));
                poll.setDescription(rs.getString("description"));
                poll.setCreatedAt(rs.getDate("created_at"));
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POLL_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return poll;
    }

    @Override
    public List<Poll> getAll() throws DAOException, DBException {
        List<Poll> pollList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Poll poll = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                poll = new Poll();
                poll.setId(rs.getInt("id"));
                poll.setUserId(rs.getInt("user_id"));
                poll.setTitle(rs.getString("title"));
                poll.setDescription(rs.getString("description"));
                poll.setCreatedAt(rs.getDate("created_at"));
                pollList.add(poll);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POLL_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return pollList;
    }

    @Override
    public int insert(Poll poll) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);

            ps.setInt(1, poll.getUserId());
            ps.setString(2, poll.getTitle());
            ps.setString(3, poll.getDescription());
            ps.setDate(4, poll.getCreatedAt());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POLL_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int update(Poll oldPoll, Poll newPoll) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, newPoll.getUserId());
            ps.setString(2, newPoll.getTitle());
            ps.setString(3, newPoll.getDescription());
            ps.setDate(4, newPoll.getCreatedAt());
            ps.setInt(5, oldPoll.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POLL_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int delete(Poll poll) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, poll.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POLL_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

}