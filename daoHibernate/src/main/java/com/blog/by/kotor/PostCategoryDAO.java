package com.blog.by.kotor;

import com.blog.by.kotor.PostCategory.PostCategory;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;


public class PostCategoryDAO extends AbstractHibernateDao<PostCategory> {

    public PostCategoryDAO() {
        super(PostCategory.class);
    }

    public List<PostCategory> findPostsAndCategoriesByCategoryId(int categoryId) {
        String hql = "from PostCategory where id.categoryId = :categoryId";
        try (Session session = sessionFactory.openSession()) {
            Query<PostCategory> query = session.createQuery(hql, PostCategory.class);
            query.setParameter("categoryId", categoryId);
            return query.list();
        }
    }

}
