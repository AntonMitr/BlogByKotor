package com.blog.by.kotor.post;

import com.blog.by.kotor.Comment;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.Post;
import com.blog.by.kotor.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.blog.by.kotor.DAOException.POLL_DAO_EXCEPTION;
import static com.blog.by.kotor.DAOException.POST_DAO_EXCEPTION;

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

    private Connection conn;

    private PreparedStatement ps;

    private ResultSet rs;

    private final Post post;

    public PostDAOImpl(Post post) {
        this.post = post;
    }

    @Override
    public Post findById(int id) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_ID);
            ps.setInt(1, id);

            rs = ps.executeQuery();
            while (rs.next()) {
                post.setId(rs.getInt("id"));
                post.setUserId(rs.getInt("user_id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setDatePublished(rs.getDate("date_published"));
                post.setPremium(rs.getBoolean("is_premium"));
                post.setPublished(rs.getBoolean("is_published"));
            }
        } catch (SQLException e) {
            try {
                throw new DAOException(POST_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return post;
    }

    @Override
    public List<Post> getAll() {
        List<Post> postList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                post.setId(rs.getInt("id"));
                post.setUserId(rs.getInt("user_id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setDatePublished(rs.getDate("date_published"));
                post.setPremium(rs.getBoolean("is_premium"));
                post.setPublished(rs.getBoolean("is_published"));
                postList.add(post);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(POST_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return postList;
    }

    @Override
    public int insert(Post post) {
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

        } catch (SQLException e) {
            try {
                throw new DAOException(POST_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return 0;
    }

    @Override
    public int update(Post oldPost, Post newPost) {
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

        } catch (SQLException e) {
            try {
                throw new DAOException(POST_DAO_EXCEPTION);
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
    public int delete(Post post) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, post.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(POST_DAO_EXCEPTION);
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
    public List<Post> findByUserId(int userId) {
        List<Post> postList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_USER_ID);
            ps.setInt(1, userId);

            rs = ps.executeQuery();
            while (rs.next()) {
                post.setId(rs.getInt("id"));
                post.setUserId(rs.getInt("user_id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setDatePublished(rs.getDate("date_published"));
                post.setPremium(rs.getBoolean("is_premium"));
                post.setPublished(rs.getBoolean("is_published"));
                postList.add(post);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(POST_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return postList;
    }

    @Override
    public List<Post> findByTitle(String title) {
        List <Post> postList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_TITLE);
            ps.setString(1, title);

            rs = ps.executeQuery();
            while (rs.next()) {
                post.setId(rs.getInt("id"));
                post.setUserId(rs.getInt("user_id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setDatePublished(rs.getDate("date_published"));
                post.setPremium(rs.getBoolean("is_premium"));
                post.setPublished(rs.getBoolean("is_published"));
                postList.add(post);
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(POST_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return postList;
    }

    @Override
    public int publishPost(Post post) {
        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(PUBLISH);

            ps.setBoolean(1, true);
            ps.setInt(2, post.getId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            try {
                throw new DAOException(POST_DAO_EXCEPTION);
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
    public boolean isPremium(int postId) {
        boolean isPremium = false;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(IS_PREMIUM);
            ps.setInt(1, postId);

            rs = ps.executeQuery();
            while (rs.next()) {
                isPremium = rs.getBoolean("is_premium");
            }

        } catch (SQLException e) {
            try {
                throw new DAOException(POST_DAO_EXCEPTION);
            } catch (DAOException ex) {
                ex.getMessage();
            }
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return isPremium;
    }

}
