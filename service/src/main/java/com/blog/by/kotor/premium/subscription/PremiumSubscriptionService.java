package com.blog.by.kotor.premium.subscription;

import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.User;

public interface PremiumSubscriptionService {

    boolean isPremiumUser(User user) throws DAOException, DBException;

}
