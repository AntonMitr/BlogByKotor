package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class OptionDAO extends AbstractHibernateDao<Option> {

    public OptionDAO() {
        super(Option.class);
    }

    @Transactional(readOnly = true)
    public List<Option> findByQuestionId(int questionId) {
        String hql = "from Option where question.id = :questionId";
        try (Session session = sessionFactory.openSession()) {
            Query<Option> query = session.createQuery(hql, Option.class);
            query.setParameter("questionId", questionId);
            return query.list();
        }
    }

}
