package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class PremiumSubscriptionDAO extends AbstractHibernateDao<PremiumSubscription> {

    public PremiumSubscriptionDAO() {
        super(PremiumSubscription.class);
    }

    @Transactional(readOnly = true)
    public List<PremiumSubscription> findByUserId(int userId) {
        String hql = "from PremiumSubscription where user.id = :userId";
        try (Session session = sessionFactory.openSession()) {
            Query<PremiumSubscription> query = session.createQuery(hql, PremiumSubscription.class);
            query.setParameter("userId", userId);
            return query.list();
        }
    }

}
