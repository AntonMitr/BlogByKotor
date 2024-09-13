package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TagDAO extends AbstractHibernateDao<Tag> {

    public TagDAO() {
        super(Tag.class);
    }

    @Transactional(readOnly = true)
    public Tag findByName(String name) {
        String hql = "from Tag where name=:name";
        try (Session session = sessionFactory.openSession()) {
            Query<Tag> query = session.createQuery(hql, Tag.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        }
    }

}
