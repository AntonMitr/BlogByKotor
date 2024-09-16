package com.blog.by.kotor.dao;

import com.blog.by.kotor.model.PremiumSubscription;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class PremiumSubscriptionDAO extends AbstractHibernateDao<PremiumSubscription> {

    @Autowired
    public PremiumSubscriptionDAO(SessionFactory sessionFactory) {
        super(PremiumSubscription.class, sessionFactory);
    }

    @Transactional(readOnly = true)
    public List<PremiumSubscription> findByUserId(int userId) {
        String hql = "from PremiumSubscription where user.id = :userId";
        try (Session session = getSessionFactory().getCurrentSession()) {
            Query<PremiumSubscription> query = session.createQuery(hql, PremiumSubscription.class);
            query.setParameter("userId", userId);
            return query.list();
        }
    }

}
