package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class FilterDAO extends AbstractHibernateDao<Filter> {

    public FilterDAO() {
        super(Filter.class);
    }

    public Filter findByCriteria(String criteria) {
        String hql = "from Filter f where f.criteria = :criteria";
        try (Session session = sessionFactory.openSession()) {
            Query<Filter> query = session.createQuery(hql, Filter.class);
            query.setParameter("criteria", criteria);
            return query.uniqueResult();
        }
    }

}
