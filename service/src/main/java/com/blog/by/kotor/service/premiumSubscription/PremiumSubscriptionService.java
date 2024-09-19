package com.blog.by.kotor.service.premiumSubscription;


import com.blog.by.kotor.model.PremiumSubscription;

import java.util.List;

public interface PremiumSubscriptionService {

    void createPremiumSubscription(PremiumSubscription premiumSubscription);

    PremiumSubscription getPremiumSubscriptionById(Integer id);

    List<PremiumSubscription> getAllPremiumSubscription();

    void updatePremiumSubscription(PremiumSubscription premiumSubscription);

    void deletePremiumSubscriptionById(Integer id);

    void deletePremiumSubscription(PremiumSubscription premiumSubscription);

}
