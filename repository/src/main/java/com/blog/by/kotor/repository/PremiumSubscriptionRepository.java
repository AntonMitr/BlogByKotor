package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.PremiumSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PremiumSubscriptionRepository extends JpaRepository<PremiumSubscription, Integer> {

    List<PremiumSubscription> findByUserId(Integer userId);

}
