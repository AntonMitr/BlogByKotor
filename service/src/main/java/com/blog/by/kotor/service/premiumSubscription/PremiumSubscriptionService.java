package com.blog.by.kotor.service.premiumSubscription;


import com.blog.by.kotor.model.PremiumSubscription;

import java.util.List;

public interface PremiumSubscriptionService {

    void createPremiumSubscription(PremiumSubscription premiumSubscription);

    PremiumSubscription findPremiumSubscriptionById(Integer id);

    List<PremiumSubscription> findAllPremiumSubscription();

    void updatePremiumSubscription(PremiumSubscription premiumSubscription);

    void deletePremiumSubscriptionById(Integer id);

    void deletePremiumSubscription(PremiumSubscription premiumSubscription);

}
