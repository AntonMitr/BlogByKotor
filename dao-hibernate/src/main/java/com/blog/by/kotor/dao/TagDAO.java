package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.Tag;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class TagDAO extends AbstractHibernateDao<Tag> {

    @Autowired
    public TagDAO(SessionFactory sessionFactory) {
        super(Tag.class, sessionFactory);
    }

    @Transactional(readOnly = true)
    public Tag findByName(String name) {
        String hql = "from Tag where name=:name";
        try (Session session = getSessionFactory().getCurrentSession()) {
            Query<Tag> query = session.createQuery(hql, Tag.class);
            query.setParameter("name", name);
            return query.getSingleResult();
        }
    }

}
