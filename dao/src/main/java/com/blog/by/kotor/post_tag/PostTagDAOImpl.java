package com.blog.by.kotor.post_tag;

import com.blog.by.kotor.*;
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

    private static PostTagDAO postTagDAO;

    private PostTagDAOImpl() {
    }

    public static PostTagDAO getPostTagDAOImpl() {
        if (postTagDAO == null) {
            postTagDAO = new PostTagDAOImpl();
        }
        return postTagDAO;
    }

    @Override
    public PostTag findById(int id) {
        return null;
    }

    @Override
    public List<PostTag> getAll() throws DAOException, DBException {
        List<PostTag> postTagList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PostTag postTag = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();
            while (rs.next()) {
                postTag = new PostTag();
                postTag.setTagId(rs.getInt("tag_id"));
                postTag.setPostId(rs.getInt("post_id"));
                postTagList.add(postTag);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_TAG_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return postTagList;
    }

    @Override
    public int insert(PostTag postTag) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);

            ps.setInt(1, postTag.getPostId());
            ps.setInt(2, postTag.getTagId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_TAG_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int update(PostTag oldPostTag, PostTag newPostTag) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, newPostTag.getPostId());
            ps.setInt(2, newPostTag.getTagId());
            ps.setInt(3, newPostTag.getPostId());
            ps.setInt(4, oldPostTag.getTagId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_TAG_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int delete(PostTag postTag) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(DELETE);

            ps.setInt(1, postTag.getPostId());
            ps.setInt(2, postTag.getTagId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_TAG_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public List<Post> findPostsByTagId(int tagId) throws DAOException, DBException {
        List<Post> postList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;


        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_TAG_ID);
            ps.setInt(1, tagId);

            rs = ps.executeQuery();
            while (rs.next()) {
                Post post = PostDAOImpl.getPostDAOImpl().findById(rs.getInt("post_id"));
                postList.add(post);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_TAG_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return postList;
    }

}
