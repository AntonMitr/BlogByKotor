package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class OptionDAO extends AbstractHibernateDao<Option> {

    private static OptionDAO optionDAO;

    private OptionDAO() {
        super(Option.class);
    }

    public static OptionDAO getOptionDAO() {
        if (optionDAO == null) {
            optionDAO = new OptionDAO();
        }
        return optionDAO;
    }

    public List<Option> findByQuestionId(int questionId) {
        String hql = "from Option where question.id = :questionId";
        try (Session session = sessionFactory.openSession()) {
            Query<Option> query = session.createQuery(hql, Option.class);
            query.setParameter("questionId", questionId);
            return query.list();
        }
    }

}
