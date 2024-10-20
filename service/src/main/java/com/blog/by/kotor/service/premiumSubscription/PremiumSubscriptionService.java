package com.blog.by.kotor.service.premiumSubscription;


import com.blog.by.kotor.dto.model.PremiumSubscriptionDTO;
import com.blog.by.kotor.model.PremiumSubscription;

import java.util.List;

public interface PremiumSubscriptionService {

    void createPremiumSubscription(PremiumSubscriptionDTO premiumSubscriptionDTO);

    PremiumSubscription findPremiumSubscriptionById(Integer id);

    List<PremiumSubscription> findAllPremiumSubscription();

    void updatePremiumSubscription(PremiumSubscriptionDTO premiumSubscriptionDTO, Integer id);

    void deletePremiumSubscriptionById(Integer id);

}
