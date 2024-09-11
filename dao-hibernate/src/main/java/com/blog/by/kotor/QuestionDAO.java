package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;

public class QuestionDAO extends AbstractHibernateDao<Question> {

    private static QuestionDAO questionDAO;

    private QuestionDAO() {
        super(Question.class);
    }

    public static QuestionDAO getQuestionDAO() {
        if (questionDAO == null) {
            questionDAO = new QuestionDAO();
        }
        return questionDAO;
    }

    public Question findByPollId(int pollId) {
        String hql = "from Question where poll.id = :pollId";
        try (Session session = sessionFactory.openSession()) {
            Query<Question> query = session.createQuery(hql, Question.class);
            query.setParameter("pollId", pollId);
            return query.getSingleResult();
        }
    }

}
