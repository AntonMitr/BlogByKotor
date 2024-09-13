package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostDAO extends AbstractHibernateDao<Post> {

    public PostDAO() {
        super(Post.class);
    }

    @Transactional(readOnly = true)
    public List<Post> findByUserId(int userId) {
        String hql = "from Post where user.id = :userId";
        try (Session session = sessionFactory.openSession()) {
            Query<Post> query = session.createQuery(hql, Post.class);
            query.setParameter("userId", userId);
            return query.list();
        }
    }

    @Transactional(readOnly = true)
    public List<Post> findByTitle(String title) {
        String hql = "from Post where title like :title";
        try (Session session = sessionFactory.openSession()) {
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
