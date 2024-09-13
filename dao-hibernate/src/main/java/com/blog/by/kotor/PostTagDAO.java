package com.blog.by.kotor;

import com.blog.by.kotor.PostTag.PostTag;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PostTagDAO extends AbstractHibernateDao<PostTag> {

    public PostTagDAO() {
        super(PostTag.class);
    }

    @Transactional(readOnly = true)
    public List<PostTag> findPostTagByTagId(int tagId) {
        String hql = "from PostTag where id.tagId = :tagId";
        try (Session session = sessionFactory.openSession()) {
            Query<PostTag> query = session.createQuery(hql, PostTag.class);
            query.setParameter("tagId", tagId);
            return query.list();
        }
    }

}
