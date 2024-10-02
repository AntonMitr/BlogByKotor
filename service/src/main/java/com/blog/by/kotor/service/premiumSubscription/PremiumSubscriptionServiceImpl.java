package com.blog.by.kotor.service.premiumSubscription;

import com.blog.by.kotor.exception.ErrorCode;
import com.blog.by.kotor.exception.create.CreateException;
import com.blog.by.kotor.exception.delete.DeleteException;
import com.blog.by.kotor.exception.find.by.id.FindByIdException;
import com.blog.by.kotor.exception.update.UpdateException;
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
        if(premiumSubscription.getId() == null){
            throw new CreateException(ErrorCode.PREMIUM_SUBSCRIPTION_ID);
        }
        if(premiumSubscription.getUser().getId() == null){
            throw new CreateException(ErrorCode.PREMIUM_SUBSCRIPTION_USER_ID);
        }
        if(premiumSubscription.getStartDate() == null){
            throw new CreateException(ErrorCode.PREMIUM_SUBSCRIPTION_START_DATE);
        }
        if(premiumSubscription.getEndDate() == null){
            throw new CreateException(ErrorCode.PREMIUM_SUBSCRIPTION_START_DATE);
        }
        premiumSubscriptionRepository.save(premiumSubscription);
    }

    @Override
    public PremiumSubscription findPremiumSubscriptionById(Integer id) {
        return premiumSubscriptionRepository.findById(id)
                .orElseThrow(() -> new FindByIdException(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, id));

    }

    @Override
    public List<PremiumSubscription> findAllPremiumSubscription() {
        return premiumSubscriptionRepository.findAll();
    }

    @Override
    @Transactional
    public void updatePremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionRepository.findById(premiumSubscription.getId())
                .orElseThrow(() -> new UpdateException(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, premiumSubscription.getId()));
        premiumSubscriptionRepository.save(premiumSubscription);
    }

    @Override
    @Transactional
    public void deletePremiumSubscriptionById(Integer id) {
        premiumSubscriptionRepository.findById(id)
                .orElseThrow(() -> new DeleteException(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, id));
        premiumSubscriptionRepository.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionRepository.findById(premiumSubscription.getId()).orElseThrow(() -> new DeleteException(ErrorCode.PREMIUM_SUBSCRIPTION_NOT_FOUND, premiumSubscription.getId()));
        premiumSubscriptionRepository.delete(premiumSubscription);
    }

}
