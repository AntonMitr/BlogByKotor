package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class FilterDAO extends AbstractHibernateDao<Filter> {

    private static FilterDAO filterDAO;

    private FilterDAO() {
        super(Filter.class);
    }

    public static FilterDAO getFilterDAO() {
        if (filterDAO == null) {
            filterDAO = new FilterDAO();
        }
        return filterDAO;
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
