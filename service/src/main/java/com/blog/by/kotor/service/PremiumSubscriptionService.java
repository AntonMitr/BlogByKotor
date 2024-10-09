package com.blog.by.kotor.service;


import com.blog.by.kotor.model.PremiumSubscription;

import java.util.List;

public interface PremiumSubscriptionService {

    void createPremiumSubscription(PremiumSubscription premiumSubscription);

    PremiumSubscription getPremiumSubscriptionById(int id);

    List<PremiumSubscription> getAllPremiumSubscription();

    void updatePremiumSubscription(PremiumSubscription premiumSubscription);

    void deletePremiumSubscriptionById(int id);

    void deletePremiumSubscription(PremiumSubscription premiumSubscription);

}
