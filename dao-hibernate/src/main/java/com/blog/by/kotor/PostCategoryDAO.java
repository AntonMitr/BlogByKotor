package com.blog.by.kotor;

import com.blog.by.kotor.postCategory.PostCategory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class PostCategoryDAO extends AbstractHibernateDao<PostCategory> {

    private static PostCategoryDAO postCategoryDAO;

    private PostCategoryDAO() {
        super(PostCategory.class);
    }

    public static PostCategoryDAO getPostCategoryDAO() {
        if (postCategoryDAO == null) {
            postCategoryDAO = new PostCategoryDAO();
        }
        return postCategoryDAO;
    }

    public List<PostCategory> findPostsAndCategoriesByCategoryId(int categoryId) {
        String hql = "from PostCategory postCategory where postCategory.id.categoryId = :categoryId";
        try (Session session = sessionFactory.openSession()) {
            Query<PostCategory> query = session.createQuery(hql, PostCategory.class);
            query.setParameter("categoryId", categoryId);
            return query.list();
        }
    }

}
