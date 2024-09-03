package com.blog.by.kotor.premium.subscription;

import com.blog.by.kotor.User;

public class PremiumSubscriptionService implements ImplPremiumSubscription {

    private final PremiumSubscriptionDAO premiumSubscriptionDAO;

    public PremiumSubscriptionService(PremiumSubscriptionDAOImpl premiumSubscriptionDAOImpl) {
        premiumSubscriptionDAO = premiumSubscriptionDAOImpl;
    }

    @Override
    public boolean isPremiumUser(User user) {
        return premiumSubscriptionDAO.isPremiumSubscription(user.getId());
    }

}
