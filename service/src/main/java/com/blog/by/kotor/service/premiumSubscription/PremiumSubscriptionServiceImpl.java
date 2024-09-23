package com.blog.by.kotor.service.premiumSubscription;

import com.blog.by.kotor.repository.PremiumSubscriptionRepository;
import com.blog.by.kotor.model.PremiumSubscription;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PremiumSubscriptionServiceImpl implements PremiumSubscriptionService {

    private final PremiumSubscriptionRepository premiumSubscriptionRepository;

    @Override
    @Transactional
    public void createPremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionRepository.save(premiumSubscription);
    }

    @Override
    @Transactional(readOnly = true)
    public PremiumSubscription findPremiumSubscriptionById(Integer id) {
        return premiumSubscriptionRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PremiumSubscription> findAllPremiumSubscription() {
        return premiumSubscriptionRepository.findAll();
    }

    @Override
    @Transactional
    public void updatePremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionRepository.saveAndFlush(premiumSubscription);
    }

    @Override
    @Transactional
    public void deletePremiumSubscriptionById(Integer id) {
        premiumSubscriptionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionRepository.delete(premiumSubscription);
    }

}
