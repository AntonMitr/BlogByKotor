package com.blog.by.kotor;

import com.blog.by.kotor.premium.subscription.PremiumSubscriptionDAO;
import com.blog.by.kotor.premium.subscription.PremiumSubscriptionDAOImpl;

public class PremiumSubscriptionService {

    public boolean isPremiumUser(User user) {
        PremiumSubscriptionDAO premiumSubscriptionDAO = new PremiumSubscriptionDAOImpl();
        return premiumSubscriptionDAO.isPremiumSubscription(user.getId());
    }

}
