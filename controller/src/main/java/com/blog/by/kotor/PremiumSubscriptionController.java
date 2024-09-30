package com.blog.by.kotor;

import com.blog.by.kotor.model.PremiumSubscription;
import com.blog.by.kotor.service.premiumSubscription.PremiumSubscriptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/premium-subscriptions")
@RequiredArgsConstructor
public class PremiumSubscriptionController {

    private final PremiumSubscriptionService premiumSubscriptionService;

    @GetMapping("/all")
    public ResponseEntity<?> getAllPremiumSubscriptions() {
        return new ResponseEntity<>(premiumSubscriptionService.findAllPremiumSubscription(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPremiumSubscriptionById(@PathVariable Integer id) {
        return new ResponseEntity<>(premiumSubscriptionService.findPremiumSubscriptionById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createPremiumSubscription(@RequestBody PremiumSubscription premiumSubscription) {
        premiumSubscriptionService.createPremiumSubscription(premiumSubscription);
        return new ResponseEntity<>(premiumSubscription, HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<?> updatePremiumSubscription(@RequestBody PremiumSubscription premiumSubscription) {
        premiumSubscriptionService.updatePremiumSubscription(premiumSubscription);
        return new ResponseEntity<>(premiumSubscription, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePremiumSubscription(@PathVariable Integer id) {
        premiumSubscriptionService.deletePremiumSubscriptionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
