package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class UserAnswerDAO extends AbstractHibernateDao<UserAnswer> {

    public UserAnswerDAO() {
        super(UserAnswer.class);
    }

    public List<UserAnswer> findByQuestionId(int questionId) {
        String hql = "from UserAnswer where question.id = :questionId";
        try (Session session = sessionFactory.openSession()) {
            Query<UserAnswer> query = session.createQuery(hql, UserAnswer.class);
            query.setParameter("questionId", questionId);
            return query.list();
        }
    }

    public List<UserAnswer> findByOptionId(int optionId) {
        String hql = "from UserAnswer where optionId = :optionId";
        try (Session session = sessionFactory.openSession()) {
            Query<UserAnswer> query = session.createQuery(hql, UserAnswer.class);
            query.setParameter("optionId", optionId);
            return query.list();
        }
    }

}
