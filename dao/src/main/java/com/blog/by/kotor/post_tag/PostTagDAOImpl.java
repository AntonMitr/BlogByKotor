package com.blog.by.kotor.post_tag;

import com.blog.by.kotor.Comment;
import com.blog.by.kotor.Post;
import com.blog.by.kotor.PostTag;
import com.blog.by.kotor.DatabaseConnection;
import com.blog.by.kotor.post.PostDAO;
import com.blog.by.kotor.post.PostDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostTagDAOImpl implements PostTagDAO {

    private static final String DELETE = "DELETE FROM posts_tags WHERE post_id = ? AND tag_id = ?";
    private static final String FIND_ALL = "SELECT * FROM posts_tags";
    private static final String FIND_BY_TAG_ID = "SELECT * FROM posts_tags WHERE tag_id = ?";
    private static final String INSERT = "INSERT INTO posts_tags (post_id, tag_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE posts_tags SET post_id = ?, tag_id = ? WHERE post_id = ? AND tag_id = ?";

    private Connection conn;

    private PreparedStatement ps;

    private ResultSet rs;

    private final PostTag postTag;

    private final PostDAO postDAO;

    private Post post;

    private List<PostTag> postTagList;

    private List<Post> postList;

    public PostTagDAOImpl() {
        postTag = new PostTag();
        post = new Post();
        postDAO = new PostDAOImpl();
    }

    @Override
    public PostTag findById(int id) {
        return null;
    }

    @Override
    public List<PostTag> getAll() {
        postTagList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                postTag.setTagId(rs.getInt("tag_id"));
                postTag.setPostId(rs.getInt("post_id"));
                postTagList.add(postTag);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return postTagList;
    }

    @Override
    public int insert(PostTag postTag) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, postTag.getPostId());
            ps.setInt(2, postTag.getTagId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public int update(PostTag oldPostTag, PostTag newPostTag) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, newPostTag.getPostId());
            ps.setInt(2, newPostTag.getTagId());
            ps.setInt(3, newPostTag.getPostId());
            ps.setInt(4, oldPostTag.getTagId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public int delete(PostTag postTag) {
        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, postTag.getPostId());
            ps.setInt(2, postTag.getTagId());

            return ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
        return 0;
    }

    @Override
    public List<Post> findPostsByTagId(int tagId) {
        postList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_TAG_ID);
            ps.setInt(1, tagId);

            rs = ps.executeQuery();
            while (rs.next()) {
                post = postDAO.findById(rs.getInt("post_id"));
                postList.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return postList;
    }

}
