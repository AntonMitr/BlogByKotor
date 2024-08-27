package com.blog.by.kotor.premium.subscription;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.PremiumSubscription;

import java.util.List;

public interface PremiumSubscriptionDAO extends DAO<PremiumSubscription> {

    List<PremiumSubscription> findByUserId(int userId);

    boolean isPremiumSubscription(int userId);

}
