package com.blog.by.kotor.service.premiumSubscription;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.delete.DeleteExceptionFactory;
import com.blog.by.kotor.exception.find.by.id.FindByIdExceptionFactory;
import com.blog.by.kotor.exception.update.UpdateExceptionFactory;
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
        return premiumSubscriptionRepository.findById(id).orElseThrow(() -> FindByIdExceptionFactory.moduleNotFound(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, id));

    }

    @Override
    public List<PremiumSubscription> findAllPremiumSubscription() {
        return premiumSubscriptionRepository.findAll();
    }

    @Override
    @Transactional
    public void updatePremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionRepository.findById(premiumSubscription.getId()).orElseThrow(() -> UpdateExceptionFactory.moduleNotFound(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, premiumSubscription.getId()));
        premiumSubscriptionRepository.save(premiumSubscription);
    }

    @Override
    @Transactional
    public void deletePremiumSubscriptionById(Integer id) {
        premiumSubscriptionRepository.findById(id).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, id));
        premiumSubscriptionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionRepository.findById(premiumSubscription.getId()).orElseThrow(() -> DeleteExceptionFactory.moduleNotFound(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, premiumSubscription.getId()));
        premiumSubscriptionRepository.delete(premiumSubscription);
    }

}
