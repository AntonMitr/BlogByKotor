package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class CategoryDAO extends AbstractHibernateDao<Category> {

    public CategoryDAO() {
        super(Category.class);
    }

    public Category findByName(String name) {
        String hql = "from Category c where c.name=:name";
        try (Session session = sessionFactory.openSession()) {
            Query<Category> query = session.createQuery(hql, Category.class);
            query.setParameter("name", name);
            return query.uniqueResult();
        }
    }

}