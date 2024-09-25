package com.blog.by.kotor.post;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.DatabaseConnection;
import com.blog.by.kotor.Post;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostDAOImpl implements PostDAO {

    private static final String DELETE = "DELETE FROM posts WHERE id = ?";
    private static final String FIND_ALL = "SELECT * FROM posts ORDER BY id";
    private static final String FIND_BY_ID = "SELECT * FROM posts WHERE id = ?";
    private static final String FIND_BY_USER_ID = "SELECT * FROM posts WHERE user_id = ?";
    private static final String FIND_BY_TITLE = "SELECT * FROM posts WHERE title = ?";
    private static final String IS_PREMIUM = "SELECT * FROM posts WHERE id = ?";
    private static final String INSERT = "INSERT INTO posts (user_id, title, content, date_published, is_premium, is_published) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE posts SET (user_id = ?, title = ?, content = ?, date_published = ?, is_premium = ?, is_published = ? WHERE id = ?";
    private static final String PUBLISH = "UPDATE posts SET is_published = ? WHERE id = ?";

    private static PostDAO postDAO;

    private PostDAOImpl() {
    }

    public static PostDAO getPostDAOImpl() {
        if (postDAO == null) {
            postDAO = new PostDAOImpl();
        }
        return postDAO;
    }

    @Override
    public Post findById(int id) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Post post = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setUserId(rs.getInt("user_id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setDatePublished(rs.getDate("date_published"));
                post.setPremium(rs.getBoolean("is_premium"));
                post.setPublished(rs.getBoolean("is_published"));
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return post;
    }

    @Override
    public List<Post> getAll() throws DAOException, DBException {
        List<Post> postList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Post post = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setUserId(rs.getInt("user_id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setDatePublished(rs.getDate("date_published"));
                post.setPremium(rs.getBoolean("is_premium"));
                post.setPublished(rs.getBoolean("is_published"));
                postList.add(post);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return postList;
    }

    @Override
    public int insert(Post post) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);

            ps.setInt(1, post.getUserId());
            ps.setString(2, post.getTitle());
            ps.setString(3, post.getContent());
            ps.setDate(4, post.getDatePublished());
            ps.setBoolean(5, post.isPremium());
            ps.setBoolean(6, post.isPublished());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
    }

    @Override
    public int update(Post oldPost, Post newPost) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, newPost.getUserId());
            ps.setString(2, newPost.getTitle());
            ps.setString(3, newPost.getContent());
            ps.setDate(4, newPost.getDatePublished());
            ps.setBoolean(5, newPost.isPremium());
            ps.setBoolean(6, newPost.isPublished());
            ps.setInt(7, oldPost.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int delete(Post post) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, post.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public List<Post> findByUserId(int userId) throws DAOException, DBException {
        List<Post> postList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Post post = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_USER_ID);
            ps.setInt(1, userId);

            rs = ps.executeQuery();
            while (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setUserId(rs.getInt("user_id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setDatePublished(rs.getDate("date_published"));
                post.setPremium(rs.getBoolean("is_premium"));
                post.setPublished(rs.getBoolean("is_published"));
                postList.add(post);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return postList;
    }

    @Override
    public List<Post> findByTitle(String title) throws DAOException, DBException {
        List<Post> postList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Post post = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_TITLE);
            ps.setString(1, title);

            rs = ps.executeQuery();
            while (rs.next()) {
                post = new Post();
                post.setId(rs.getInt("id"));
                post.setUserId(rs.getInt("user_id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setDatePublished(rs.getDate("date_published"));
                post.setPremium(rs.getBoolean("is_premium"));
                post.setPublished(rs.getBoolean("is_published"));
                postList.add(post);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return postList;
    }

    @Override
    public int publishPost(Post post) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(PUBLISH);

            ps.setBoolean(1, true);
            ps.setInt(2, post.getId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public boolean isPremium(int postId) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        boolean isPremium = false;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(IS_PREMIUM);
            ps.setInt(1, postId);

            rs = ps.executeQuery();
            while (rs.next()) {
                isPremium = rs.getBoolean("is_premium");
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return isPremium;
    }

}
