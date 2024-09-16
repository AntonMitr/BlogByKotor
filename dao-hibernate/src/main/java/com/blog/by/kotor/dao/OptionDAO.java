package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.Option;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class OptionDAO extends AbstractHibernateDao<Option> {

    public OptionDAO(SessionFactory sessionFactory) {
        super(Option.class, sessionFactory);
    }

    @Transactional(readOnly = true)
    public List<Option> findByQuestionId(int questionId) {
        String hql = "from Option where question.id = :questionId";
        try (Session session = getSessionFactory().getCurrentSession()) {
            Query<Option> query = session.createQuery(hql, Option.class);
            query.setParameter("questionId", questionId);
            return query.list();
        }
    }

}
