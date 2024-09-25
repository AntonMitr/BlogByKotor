package com.blog.by.kotor.premiumSubscription.service;

import com.blog.by.kotor.PremiumSubscription;
import com.blog.by.kotor.PremiumSubscriptionDAO;

import java.util.List;

public class PremiumSubscriptionServiceImpl implements PremiumSubscriptionService {

    private final PremiumSubscriptionDAO premiumSubscriptionDAO;

    public PremiumSubscriptionServiceImpl() {
        premiumSubscriptionDAO = PremiumSubscriptionDAO.getPremiumSubscriptionDAO();
    }


    @Override
    public void createPremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionDAO.create(premiumSubscription);
    }

    @Override
    public PremiumSubscription getPremiumSubscriptionById(int id) {
        return premiumSubscriptionDAO.getById(id);
    }

    @Override
    public List<PremiumSubscription> getAllPremiumSubscription() {
        return premiumSubscriptionDAO.getAll();
    }

    @Override
    public void updatePremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionDAO.update(premiumSubscription);
    }

    @Override
    public void deletePremiumSubscriptionById(int id) {
        premiumSubscriptionDAO.deleteById(id);
    }

    @Override
    public void deletePremiumSubscription(PremiumSubscription premiumSubscription) {
        premiumSubscriptionDAO.delete(premiumSubscription);
    }

}
