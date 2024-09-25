package com.blog.by.kotor.premium.subscription;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.User;

public class PremiumSubscriptionServiceImpl implements PremiumSubscriptionService {

    public PremiumSubscriptionServiceImpl() {
    }

    @Override
    public boolean isPremiumUser(User user) throws DAOException, DBException {
        return PremiumSubscriptionDAOImpl.getPremiumSubscriptionDAOImpl().isPremiumSubscription(user.getId());
    }

}
