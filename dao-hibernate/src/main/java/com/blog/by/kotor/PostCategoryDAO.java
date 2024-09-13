package com.blog.by.kotor;

import com.blog.by.kotor.PostCategory.PostCategory;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostCategoryDAO extends AbstractHibernateDao<PostCategory> {

    public PostCategoryDAO() {
        super(PostCategory.class);
    }

    @Transactional(readOnly = true)
    public List<PostCategory> findPostsAndCategoriesByCategoryId(int categoryId) {
        String hql = "from PostCategory postCategory where postCategory.id.categoryId = :categoryId";
        try (Session session = sessionFactory.openSession()) {
            Query<PostCategory> query = session.createQuery(hql, PostCategory.class);
            query.setParameter("categoryId", categoryId);
            return query.list();
        }
    }

}
