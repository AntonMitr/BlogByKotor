package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class QuestionDAO extends AbstractHibernateDao<Question> {

    @Autowired
    public QuestionDAO(SessionFactory sessionFactory) {
        super(Question.class, sessionFactory);
    }

    @Transactional(readOnly = true)
    public Question findByPollId(int pollId) {
        String hql = "from Question where poll.id = :pollId";
        try (Session session = getSessionFactory().getCurrentSession()) {
            Query<Question> query = session.createQuery(hql, Question.class);
            query.setParameter("pollId", pollId);
            return query.getSingleResult();
        }
    }

}
