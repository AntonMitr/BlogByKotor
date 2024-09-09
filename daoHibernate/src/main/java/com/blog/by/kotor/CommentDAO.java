package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CommentDAO extends AbstractHibernateDao<Comment> {

    public CommentDAO() {
        super(Comment.class);
    }

    public List<Comment> findByPostId(int postId) {
        String hql = "from Comment where post.id = :postId";
        try (Session session = sessionFactory.openSession()) {
            Query<Comment> query = session.createQuery(hql, Comment.class);
            query.setParameter("postId", postId);
            return query.list();
        }
    }
}
