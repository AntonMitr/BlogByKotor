package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class TagDAO extends AbstractHibernateDao<Tag> {

    public TagDAO() {
        super(Tag.class);
    }

    public Tag findByName(String name) {
        String hql = "from Tag where name=:name";
        try (Session session = sessionFactory.openSession()) {
            Query<Tag> query = session.createQuery(hql, Tag.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        }
    }

}
