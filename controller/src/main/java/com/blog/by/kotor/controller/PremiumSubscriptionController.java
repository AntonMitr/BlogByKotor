package com.blog.by.kotor.controller;

import com.blog.by.kotor.model.PremiumSubscription;
import com.blog.by.kotor.service.premiumSubscription.PremiumSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/premiumSubscription")
@RequiredArgsConstructor
public class PremiumSubscriptionController {

    private final PremiumSubscriptionService premiumSubscriptionService;

    @GetMapping("/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<?> viewAllPremiumSubscriptions() {
        return new ResponseEntity<>(premiumSubscriptionService.findAllPremiumSubscription(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> viewPremiumSubscriptionById(@PathVariable Integer id) {
        return new ResponseEntity<>(premiumSubscriptionService.findPremiumSubscriptionById(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<?> addPremiumSubscription(@RequestBody PremiumSubscription premiumSubscription) {
        premiumSubscriptionService.createPremiumSubscription(premiumSubscription);
        return new ResponseEntity<>(premiumSubscription, HttpStatus.CREATED);
    }

    @PutMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    public ResponseEntity<?> updatePremiumSubscription(@RequestBody PremiumSubscription premiumSubscription) {
        premiumSubscriptionService.updatePremiumSubscription(premiumSubscription);
        return new ResponseEntity<>(premiumSubscription, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR'))")
    public ResponseEntity<?> deletePremiumSubscription(@PathVariable Integer id) {
        premiumSubscriptionService.deletePremiumSubscriptionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
