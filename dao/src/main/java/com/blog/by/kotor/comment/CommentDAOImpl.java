package com.blog.by.kotor.comment;

import com.blog.by.kotor.Comment;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {

    private static final String DELETE = "DELETE FROM comments WHERE id = ?";
    private static final String FIND_BY_POST_ID = "SELECT * FROM comments WHERE post_id = ?";
    private static final String FIND_ALL = "SELECT * FROM comments ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM comments WHERE id = ?";
    private static final String INSERT = "INSERT INTO comments (user_id, post_id, content, created_at) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE comments SET user_id = ?, post_id = ?, content = ?, created_at = ? WHERE id = ?";

    private static CommentDAO commentDAO;

    private CommentDAOImpl() {
    }

    public static CommentDAO getCommentDAOImpl() {
        if (commentDAO == null) {
            commentDAO = new CommentDAOImpl();
        }
        return commentDAO;
    }

    @Override
    public Comment findById(int id) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comment comment = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setUserId(rs.getInt("user_id"));
                comment.setPostId(rs.getInt("post_id"));
                comment.setContent(rs.getString("content"));
                comment.setCreatedAt(rs.getDate("created_at"));
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.COMMENT_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return comment;
    }

    @Override
    public List<Comment> getAll() throws DAOException, DBException {
        List<Comment> commentList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comment comment = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setUserId(rs.getInt("user_id"));
                comment.setPostId(rs.getInt("post_id"));
                comment.setContent(rs.getString("content"));
                comment.setCreatedAt(rs.getDate("created_at"));
                commentList.add(comment);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.COMMENT_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return commentList;
    }

    @Override
    public List<Comment> findByPostId(int postId) throws DAOException, DBException {
        List<Comment> commentList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Comment comment = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_POST_ID);
            ps.setInt(1, postId);

            rs = ps.executeQuery();
            while (rs.next()) {
                comment = new Comment();
                comment.setId(rs.getInt("id"));
                comment.setUserId(rs.getInt("user_id"));
                comment.setPostId(rs.getInt("post_id"));
                comment.setContent(rs.getString("content"));
                comment.setCreatedAt(rs.getDate("created_at"));
                commentList.add(comment);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.COMMENT_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return commentList;
    }

    @Override
    public int insert(Comment comment) throws DAOException, DBException{
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);

            ps.setInt(1, comment.getUserId());
            ps.setInt(2, comment.getPostId());
            ps.setString(3, comment.getContent());
            ps.setDate(4, comment.getCreatedAt());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.COMMENT_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int update(Comment oldComment, Comment newComment) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, newComment.getUserId());
            ps.setInt(2, newComment.getPostId());
            ps.setString(3, newComment.getContent());
            ps.setDate(4, newComment.getCreatedAt());
            ps.setInt(5, oldComment.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.COMMENT_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int delete(Comment comment) throws DAOException, DBException{
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, comment.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.COMMENT_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

}
