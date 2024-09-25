package com.blog.by.kotor;

import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class PremiumSubscriptionDAO extends AbstractHibernateDao<PremiumSubscription> {

    private static PremiumSubscriptionDAO premiumSubscriptionDAO;

    private PremiumSubscriptionDAO() {
        super(PremiumSubscription.class);
    }

    public static PremiumSubscriptionDAO getPremiumSubscriptionDAO() {
        if (premiumSubscriptionDAO == null) {
            premiumSubscriptionDAO = new PremiumSubscriptionDAO();
        }
        return premiumSubscriptionDAO;
    }

    public List<PremiumSubscription> findByUserId(int userId) {
        String hql = "from PremiumSubscription where user.id = :userId";
        try (Session session = sessionFactory.openSession()) {
            Query<PremiumSubscription> query = session.createQuery(hql, PremiumSubscription.class);
            query.setParameter("userId", userId);
            return query.list();
        }
    }

}
