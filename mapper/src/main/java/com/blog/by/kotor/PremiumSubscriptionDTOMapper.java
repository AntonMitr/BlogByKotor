package com.blog.by.kotor;

import com.blog.by.kotor.dto.model.PremiumSubscriptionDTO;
import com.blog.by.kotor.model.PremiumSubscription;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PremiumSubscriptionDTOMapper {

    public PremiumSubscription toPremiumSubscription(PremiumSubscriptionDTO premiumSubscriptionDTO) {
        return PremiumSubscription.builder()
                .startLocalDate(LocalDate.now())
                .endLocalDate(LocalDate.now())
                .build();
    }

}
