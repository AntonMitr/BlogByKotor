package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class CategoryDAO extends AbstractHibernateDao<Category> {

    @Autowired
    public CategoryDAO(SessionFactory sessionFactory) {
        super(Category.class, sessionFactory);
    }

    @Transactional(readOnly = true)
    public Category findByName(String name) {
        String hql = "from Category c where c.name=:name";
        try (Session session = getSessionFactory().getCurrentSession()) {
            Query<Category> query = session.createQuery(hql, Category.class);
            query.setParameter("name", name);
            return query.uniqueResult();
        }
    }

}
