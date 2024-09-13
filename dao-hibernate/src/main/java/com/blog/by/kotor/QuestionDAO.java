package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class QuestionDAO extends AbstractHibernateDao<Question> {

    public QuestionDAO() {
        super(Question.class);
    }

    @Transactional(readOnly = true)
    public Question findByPollId(int pollId) {
        String hql = "from Question where poll.id = :pollId";
        try (Session session = sessionFactory.openSession()) {
            Query<Question> query = session.createQuery(hql, Question.class);
            query.setParameter("pollId", pollId);
            return query.getSingleResult();
        }
    }

}
