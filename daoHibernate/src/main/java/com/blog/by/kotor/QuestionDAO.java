package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class QuestionDAO extends AbstractHibernateDao<Question> {

    public QuestionDAO() {
        super(Question.class);
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
