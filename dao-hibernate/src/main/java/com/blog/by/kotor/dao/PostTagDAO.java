package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.post.tag.PostTag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PostTagDAO extends AbstractHibernateDao<PostTag> {

    @Autowired
    public PostTagDAO(SessionFactory sessionFactory) {
        super(PostTag.class, sessionFactory);
    }

    @Transactional(readOnly = true)
    public List<PostTag> findPostTagByTagId(int tagId) {
        String hql = "from PostTag where id.tagId = :tagId";
        try (Session session = getSessionFactory().openSession()) {
            Query<PostTag> query = session.createQuery(hql, PostTag.class);
            query.setParameter("tagId", tagId);
            return query.list();
        }
    }

}
