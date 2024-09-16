package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.Filter;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class FilterDAO extends AbstractHibernateDao<Filter> {

    @Autowired
    public FilterDAO(SessionFactory sessionFactory) {
        super(Filter.class, sessionFactory);
    }

    @Transactional(readOnly = true)
    public Filter findByCriteria(String criteria) {
        String hql = "from Filter f where f.criteria = :criteria";
        try (Session session = getSessionFactory().getCurrentSession()) {
            Query<Filter> query = session.createQuery(hql, Filter.class);
            query.setParameter("criteria", criteria);
            return query.uniqueResult();
        }
    }

}
