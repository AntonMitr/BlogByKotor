package com.blog.by.kotor.premium.subscription;

import com.blog.by.kotor.User;

public class PremiumSubscriptionService implements ImplPremiumSubscription {

    private final PremiumSubscriptionDAO premiumSubscriptionDAO;

    public PremiumSubscriptionService() {
        premiumSubscriptionDAO = new PremiumSubscriptionDAOImpl();
    }

    @Override
    public boolean isPremiumUser(User user) {
        return premiumSubscriptionDAO.isPremiumSubscription(user.getId());
    }

}
