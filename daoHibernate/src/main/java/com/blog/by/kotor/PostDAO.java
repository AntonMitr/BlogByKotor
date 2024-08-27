package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PostDAO extends AbstractHibernateDao<Post> {

    public PostDAO() {
        super(Post.class);
    }

    public List<Post> findByUserId(int userId) {
        String hql = "from Post where user.id = :userId";
        try (Session session = sessionFactory.openSession()) {
            Query<Post> query = session.createQuery(hql, Post.class);
            query.setParameter("userId", userId);
            return query.list();
        }
    }

    public List<Post> findByTitle(String title) {
        String hql = "from Post where title like :title";
        try (Session session = sessionFactory.openSession()) {
            Query<Post> query = session.createQuery(hql, Post.class);
            query.setParameter("title", "%" + title + "%");
            return query.list();
        }
    }

    public void publishPost(Post post) {
        try (Session session = sessionFactory.openSession()) {
            post.setPublished(true);
            update(post);
        }
    }

}
