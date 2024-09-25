package com.blog.by.kotor;

import com.blog.by.kotor.postTag.PostTag;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PostTagDAO extends AbstractHibernateDao<PostTag> {

    private static PostTagDAO postTagDAO;

    private PostTagDAO() {
        super(PostTag.class);
    }

    public static PostTagDAO getPostTagDAO() {
        if (postTagDAO == null) {
            postTagDAO = new PostTagDAO();
        }
        return postTagDAO;
    }

    public List<PostTag> findPostTagByTagId(int tagId) {
        String hql = "from PostTag where id.tagId = :tagId";
        try (Session session = sessionFactory.openSession()) {
            Query<PostTag> query = session.createQuery(hql, PostTag.class);
            query.setParameter("tagId", tagId);
            return query.list();
        }
    }

}
