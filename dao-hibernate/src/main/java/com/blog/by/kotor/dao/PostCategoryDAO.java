package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.postCategory.PostCategory;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PostCategoryDAO extends AbstractHibernateDao<PostCategory> {

    @Autowired
    public PostCategoryDAO(SessionFactory sessionFactory) {
        super(PostCategory.class, sessionFactory);
    }

    @Transactional(readOnly = true)
    public List<PostCategory> findPostsAndCategoriesByCategoryId(int categoryId) {
        String hql = "from PostCategory postCategory where postCategory.id.categoryId = :categoryId";
        try (Session session = getSessionFactory().getCurrentSession()) {
            Query<PostCategory> query = session.createQuery(hql, PostCategory.class);
            query.setParameter("categoryId", categoryId);
            return query.list();
        }
    }

}
