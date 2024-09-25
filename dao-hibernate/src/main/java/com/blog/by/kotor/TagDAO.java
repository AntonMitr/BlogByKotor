package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class TagDAO extends AbstractHibernateDao<Tag> {

    private static TagDAO tagDAO;

    private TagDAO() {
        super(Tag.class);
    }

    public static TagDAO getTagDAO() {
        if (tagDAO == null) {
            tagDAO = new TagDAO();
        }
        return tagDAO;
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
