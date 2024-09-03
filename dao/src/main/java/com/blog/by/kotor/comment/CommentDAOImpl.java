package com.blog.by.kotor.comment;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DatabaseConnection;
import com.blog.by.kotor.Comment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.blog.by.kotor.DAOException.CATEGORY_DAO_EXCEPTION;
import static com.blog.by.kotor.DAOException.COMMENT_DAO_EXCEPTION;

public class CommentDAOImpl implements CommentDAO {

    private static final String DELETE = "DELETE FROM comments WHERE id = ?";
    private static final String FIND_BY_POST_ID = "SELECT * FROM comments WHERE post_id = ?";
    private static final String FIND_ALL = "SELECT * FROM comments ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM comments WHERE id = ?";
    private static final String INSERT = "INSERT INTO comments (user_id, post_id, content, created_at) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE comments SET user_id = ?, post_id = ?, content = ?, created_at = ? WHERE id = ?";

    private Connection conn;

    private PreparedStatement ps;

    private ResultSet rs;

    private final Comment comment;

    public CommentDAOImpl(Comment comment) {
        this.comment = comment;
    }

    @Override
    public Comment findById(int id) {

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                comment.setId(rs.getInt("id"));
                comment.setUserId(rs.getInt("user_id"));
                comment.setPostId(rs.getInt("post_id"));
                comment.setContent(rs.getString("content"));
                comment.setCreatedAt(rs.getDate("created_at"));
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(COMMENT_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return comment;
    }

    @Override
    public List<Comment> getAll() {
        List<Comment> commentList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                comment.setId(rs.getInt("id"));
                comment.setUserId(rs.getInt("user_id"));
                comment.setPostId(rs.getInt("post_id"));
                comment.setContent(rs.getString("content"));
                comment.setCreatedAt(rs.getDate("created_at"));
                commentList.add(comment);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(COMMENT_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return commentList;
    }

    @Override
    public List<Comment> findByPostId(int postId) {
        List<Comment> commentList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_POST_ID);
            ps.setInt(1, postId);

            rs = ps.executeQuery();
            while (rs.next()) {
                comment.setId(rs.getInt("id"));
                comment.setUserId(rs.getInt("user_id"));
                comment.setPostId(rs.getInt("post_id"));
                comment.setContent(rs.getString("content"));
                comment.setCreatedAt(rs.getDate("created_at"));
                commentList.add(comment);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(COMMENT_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return commentList;
    }

    @Override
    public int insert(Comment comment) {

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, comment.getUserId());
            ps.setInt(2, comment.getPostId());
            ps.setString(3, comment.getContent());
            ps.setDate(4, comment.getCreatedAt());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(COMMENT_DAO_EXCEPTION);
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
    public int update(Comment oldComment, Comment newComment) {

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, newComment.getUserId());
            ps.setInt(2, newComment.getPostId());
            ps.setString(3, newComment.getContent());
            ps.setDate(4, newComment.getCreatedAt());
            ps.setInt(5, oldComment.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(COMMENT_DAO_EXCEPTION);
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
    public int delete(Comment comment) {

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, comment.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(COMMENT_DAO_EXCEPTION);
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
