package com.blog.by.kotor.post_category;

import com.blog.by.kotor.*;
import com.blog.by.kotor.post.PostDAOImpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostCategoryDAOImpl implements PostCategoryDAO {

    private static final String DELETE = "DELETE FROM posts_categories WHERE post_id = ? AND category_id = ?";
    private static final String FIND_ALL = "SELECT * FROM posts_categories ORDER BY post_id";
    private static final String FIND_BY_CATEGORY_ID = "SELECT * FROM posts_categories WHERE categories_id = ?";
    private static final String INSERT = "INSERT INTO posts_categories (post_id, categories_id) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE posts_categories SET post_id = ?, categories_id = ? WHERE post_id = ? AND categories_id = ?";

    private static PostCategoryDAO postCategoryDAO;

    private PostCategoryDAOImpl() {
    }

    public static PostCategoryDAO getPostCategoryDAOImpl() {
        if (postCategoryDAO == null) {
            postCategoryDAO = new PostCategoryDAOImpl();
        }
        return postCategoryDAO;
    }

    @Override
    public PostCategory findById(int postId) {
        return null;
    }

    @Override
    public List<PostCategory> getAll() throws DAOException, DBException {
        List<PostCategory> postCategoryList = new ArrayList<>();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        PostCategory postCategory = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();

            while (rs.next()) {
                postCategory = new PostCategory();
                postCategory.setPostId(rs.getInt("post_id"));
                postCategory.setCategoryId(rs.getInt("categories_id"));
                postCategoryList.add(postCategory);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_CATEGORY_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return postCategoryList;
    }

    @Override
    public int insert(PostCategory postCategory) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(INSERT);

            ps.setInt(1, postCategory.getPostId());
            ps.setInt(2, postCategory.getCategoryId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_CATEGORY_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int update(PostCategory oldPostCategory, PostCategory newPostCategory) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, newPostCategory.getPostId());
            ps.setInt(2, newPostCategory.getCategoryId());
            ps.setInt(3, oldPostCategory.getPostId());
            ps.setInt(4, oldPostCategory.getCategoryId());

            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_CATEGORY_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }

    @Override
    public int delete(PostCategory postCategory) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DatabaseConnection.getConnection();
            ps = conn.prepareStatement(DELETE);

            ps.setInt(1, postCategory.getPostId());
            ps.setInt(2, postCategory.getCategoryId());
            return ps.executeUpdate();
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_CATEGORY_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeConnection(conn);
            DatabaseConnection.closePreparedStatement(ps);
        }
    }


    @Override
    public List<Post> findPostsByCategoryId(int categoryId) throws DAOException, DBException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<Post> postList = new ArrayList<>();

        try {
            conn = DatabaseConnection.getConnection();

            ps = conn.prepareStatement(FIND_BY_CATEGORY_ID);
            ps.setInt(1, categoryId);

            rs = ps.executeQuery();
            while (rs.next()) {
                Post post = PostDAOImpl.getPostDAOImpl().findById(rs.getInt("post_id"));
                postList.add(post);
            }
        } catch (SQLException ex) {
            throw new DAOException(DAOException.POST_CATEGORY_DAO_EXCEPTION_TEXT, ex);
        } finally {
            DatabaseConnection.closeAll(conn, ps, rs);
        }
        return postList;
    }

}
