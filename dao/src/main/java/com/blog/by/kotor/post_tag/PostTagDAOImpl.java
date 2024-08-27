package com.blog.by.kotor.post_tag;

import com.blog.by.kotor.Post;
import com.blog.by.kotor.PostTag;
import com.blog.by.kotor.Util;
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
    private static final String UPDATE = "UPDATE posts_tags set post_id = ?, tag_id = ? WHERE post_id = ? AND tag_id = ?";

    @Override
    public PostTag findById(int id) {
        return null;
    }

    @Override
    public List<PostTag> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PostTag> postTagList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                PostTag postTag = new PostTag();
                postTag.setTagId(rs.getInt("tag_id"));
                postTag.setPostId(rs.getInt("post_id"));
                postTagList.add(postTag);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return postTagList;
    }

    @Override
    public int insert(PostTag postTag) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, postTag.getPostId());
            ps.setInt(2, postTag.getTagId());

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
    public int update(PostTag oldPostTag, PostTag newPostTag) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(UPDATE);
            ps.setInt(1, newPostTag.getPostId());
            ps.setInt(2, newPostTag.getTagId());
            ps.setInt(3, newPostTag.getPostId());
            ps.setInt(4, oldPostTag.getTagId());

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
    public int delete(PostTag postTag) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(DELETE);
            ps.setInt(1, postTag.getPostId());
            ps.setInt(2, postTag.getTagId());

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
    public List<Post> findPostsByTagId(int tagId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> postList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_TAG_ID);
            ps.setInt(1, tagId);

            rs = ps.executeQuery();
            while (rs.next()) {
                ;
                PostDAO postDAO = new PostDAOImpl();
                Post post = postDAO.findById(rs.getInt("post_id"));
                postList.add(post);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return postList;
    }

}
