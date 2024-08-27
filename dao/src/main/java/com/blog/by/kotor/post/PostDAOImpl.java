package com.blog.by.kotor.post;

import com.blog.by.kotor.Post;
import com.blog.by.kotor.Util;

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
    private static final String UPDATE = "UPDATE posts set (user_id = ?, title = ?, content = ?, date_published = ?, is_premium = ?, is_published = ? WHERE id = ?";
    private static final String PUBLISH = "UPDATE posts set is_published = ? WHERE id = ?";

    @Override
    public Post findById(int id) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Post post = null;

        try {
            conn = Util.getConnection();

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
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return post;
    }

    @Override
    public List<Post> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> postList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
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
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return postList;
    }

    @Override
    public int insert(Post post) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, post.getUserId());
            ps.setString(2, post.getTitle());
            ps.setString(3, post.getContent());
            ps.setDate(4, post.getDatePublished());
            ps.setBoolean(5, post.isPremium());
            ps.setBoolean(6, post.isPublished());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return 0;
    }

    @Override
    public int update(Post oldPost, Post newPost) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

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
            e.printStackTrace();
        } finally {
            Util.closeConnection(conn);
            Util.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public int delete(Post post) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, post.getId());

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
    public List<Post> findByUserId(int userId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> postList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_USER_ID);
            ps.setInt(1, userId);

            rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
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
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return postList;
    }

    @Override
    public List<Post> findByTitle(String title) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> postList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_TITLE);
            ps.setString(1, title);

            rs = ps.executeQuery();
            while (rs.next()) {
                Post post = new Post();
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
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return postList;
    }

    @Override
    public int publishPost(Post post) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();
            ps = conn.prepareStatement(PUBLISH);

            ps.setBoolean(1, true);
            ps.setInt(2, post.getId());

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
    public boolean isPremium(int postId) {
        boolean isPremium = false;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(IS_PREMIUM);
            ps.setInt(1, postId);

            rs = ps.executeQuery();
            while (rs.next()) {
                isPremium = rs.getBoolean("is_premium");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return isPremium;
    }

}
