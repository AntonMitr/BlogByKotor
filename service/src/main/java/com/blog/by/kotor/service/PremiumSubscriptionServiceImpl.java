package com.blog.by.kotor.service;

import com.blog.by.kotor.dao.PremiumSubscriptionDAO;
import com.blog.by.kotor.model.PremiumSubscription;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PremiumSubscriptionServiceImpl implements PremiumSubscriptionService {

    private final PremiumSubscriptionDAO premiumSubscriptionDAO;

    @Autowired
    public PremiumSubscriptionServiceImpl(PremiumSubscriptionDAO premiumSubscriptionDAO) {
        this.premiumSubscriptionDAO = premiumSubscriptionDAO;
    }

    @Override
    @Transactional
    public void createPremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionDAO.create(premiumSubscription);
    }

    @Override
    @Transactional
    public PremiumSubscription getPremiumSubscriptionById(int id) {
        return premiumSubscriptionDAO.getById(id);
    }

    @Override
    @Transactional
    public List<PremiumSubscription> getAllPremiumSubscription() {
        return premiumSubscriptionDAO.getAll();
    }

    @Override
    @Transactional
    public void updatePremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionDAO.update(premiumSubscription);
    }

    @Override
    @Transactional
    public void deletePremiumSubscriptionById(int id) {
        premiumSubscriptionDAO.deleteById(id);
    }

    @Override
    @Transactional
    public void deletePremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionDAO.delete(premiumSubscription);
    }

}
