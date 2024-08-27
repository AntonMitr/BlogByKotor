package com.blog.by.kotor.post_category;

import com.blog.by.kotor.Post;
import com.blog.by.kotor.PostCategory;
import com.blog.by.kotor.Util;
import com.blog.by.kotor.post.PostDAO;
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
    private static final String UPDATE = "UPDATE posts_categories set post_id = ?, categories_id = ? WHERE post_id = ? AND categories_id = ?";

    @Override
    public PostCategory findById(int postId) {
        return null;
    }

    @Override
    public List<PostCategory> getAll() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<PostCategory> postCategoryList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_ALL);

            rs = ps.executeQuery();

            while (rs.next()) {
                PostCategory postCategory = new PostCategory();
                postCategory.setPostId(rs.getInt("post_id"));
                postCategory.setCategoryId(rs.getInt("categories_id"));
                postCategoryList.add(postCategory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            Util.closeAll(conn, ps, rs);
        }
        return postCategoryList;
    }

    @Override
    public int insert(PostCategory postCategory) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(INSERT);
            ps.setInt(1, postCategory.getPostId());
            ps.setInt(2, postCategory.getCategoryId());

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
    public int update(PostCategory oldPostCategory, PostCategory newPostCategory) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();
            ps = conn.prepareStatement(UPDATE);

            ps.setInt(1, newPostCategory.getPostId());
            ps.setInt(2, newPostCategory.getCategoryId());
            ps.setInt(3, oldPostCategory.getPostId());
            ps.setInt(4, oldPostCategory.getCategoryId());

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
    public int delete(PostCategory postCategory) {
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = Util.getConnection();
            ps = conn.prepareStatement(DELETE);

            ps.setInt(1, postCategory.getPostId());
            ps.setInt(2, postCategory.getCategoryId());
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
    public List<Post> findPostsByCategoryId(int categoryId) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Post> postList = new ArrayList<>();

        try {
            conn = Util.getConnection();

            ps = conn.prepareStatement(FIND_BY_CATEGORY_ID);
            ps.setInt(1, categoryId);

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
