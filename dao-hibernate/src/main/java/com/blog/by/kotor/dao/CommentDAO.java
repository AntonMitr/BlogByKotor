package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.Comment;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CommentDAO extends AbstractHibernateDao<Comment> {

    @Autowired
    public CommentDAO(SessionFactory sessionFactory) {
        super(Comment.class, sessionFactory);
    }

    @Transactional(readOnly = true)
    public List<Comment> findByPostId(int postId) {
        String hql = "from Comment where post.id = :postId";
        try (Session session = getSessionFactory().getCurrentSession()) {
            Query<Comment> query = session.createQuery(hql, Comment.class);
            query.setParameter("postId", postId);
            return query.list();
        }
    }
}
