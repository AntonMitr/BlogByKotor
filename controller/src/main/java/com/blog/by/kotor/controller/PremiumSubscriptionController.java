package com.blog.by.kotor.controller;

import com.blog.by.kotor.dto.model.PremiumSubscriptionDTO;
import com.blog.by.kotor.service.premiumSubscription.PremiumSubscriptionService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
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
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "PremiumSubscription не найден")
    })
    public ResponseEntity<?> viewPremiumSubscriptionById(@PathVariable @Parameter(description = "Индентификатор премиум подписки", example = "1") Integer id) {
        return new ResponseEntity<>(premiumSubscriptionService.findPremiumSubscriptionById(id), HttpStatus.OK);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Ошибка валидации")
    })
    public ResponseEntity<?> addPremiumSubscription(@RequestBody @Validated PremiumSubscriptionDTO premiumSubscriptionDTO) {
        premiumSubscriptionService.createPremiumSubscription(premiumSubscriptionDTO);
        return new ResponseEntity<>(premiumSubscriptionDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "PremiumSubscription не найден")
    })
    public ResponseEntity<?> updatePremiumSubscription(@RequestBody PremiumSubscriptionDTO premiumSubscriptionDTO, @PathVariable @Parameter(description = "Индентификатор премиум подписки", example = "1") Integer id) {
        premiumSubscriptionService.updatePremiumSubscription(premiumSubscriptionDTO, id);
        return new ResponseEntity<>(premiumSubscriptionDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('MODERATOR')")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "404", description = "PremiumSubscription не найден")
    })
    public ResponseEntity<?> deletePremiumSubscription(@PathVariable @Parameter(description = "Индентификатор премиум подписки", example = "1") Integer id) {
        premiumSubscriptionService.deletePremiumSubscriptionById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
