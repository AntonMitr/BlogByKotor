package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OptionDAO extends AbstractHibernateDao<Option> {

    public OptionDAO() {
        super(Option.class);
    }

    public List<Option> findByQuestionId(int questionId) {
        String hql = "from Option where questionId = :questionId";
        try (Session session = sessionFactory.openSession()) {
            Query<Option> query = session.createQuery(hql, Option.class);
            query.setParameter("questionId", questionId);
            return query.list();
        }
    }

}
