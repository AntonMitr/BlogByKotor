package com.blog.by.kotor.premium.subscription;

import com.blog.by.kotor.DAO;
import com.blog.by.kotor.DAOException;
import com.blog.by.kotor.DBException;
import com.blog.by.kotor.PremiumSubscription;

import java.util.List;

public interface PremiumSubscriptionDAO extends DAO<PremiumSubscription> {

    List<PremiumSubscription> findByUserId(int userId) throws DAOException, DBException;

    boolean isPremiumSubscription(int userId) throws DAOException, DBException;

}
