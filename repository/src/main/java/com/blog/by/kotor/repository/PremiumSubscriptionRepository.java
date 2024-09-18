package com.blog.by.kotor.repository;

import com.blog.by.kotor.model.PremiumSubscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PremiumSubscriptionRepository extends JpaRepository<PremiumSubscription, Integer> {

    @Query("select p from PremiumSubscription p join p.user u where u.id = ?1")
    List<PremiumSubscription> findByUserId(Integer userId);

}
