package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.Post;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PostDAO extends AbstractHibernateDao<Post> {

    @Autowired
    public PostDAO(SessionFactory sessionFactory) {
        super(Post.class, sessionFactory);
    }

    @Transactional(readOnly = true)
    public List<Post> findByUserId(int userId) {
        String hql = "from Post where user.id = :userId";
        try (Session session = getSessionFactory().getCurrentSession()) {
            Query<Post> query = session.createQuery(hql, Post.class);
            query.setParameter("userId", userId);
            return query.list();
        }
    }

    @Transactional(readOnly = true)
    public List<Post> findByTitle(String title) {
        String hql = "from Post where title like :title";
        try (Session session = getSessionFactory().getCurrentSession()) {
            Query<Post> query = session.createQuery(hql, Post.class);
            query.setParameter("title", "%" + title + "%");
            return query.list();
        }
    }

    @Transactional
    public void publishPost(Post post) {
        post.setPublished(true);
        update(post);
    }

}
