package org.example.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.example.dto.SubscriptionRequestDto;
import org.example.dto.SubscriptionResponseDto;
import org.example.entity.Subscription;
import org.example.service.SubscriptionService;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/subscriptions")
@Log
public class ServiceControllerImpl implements ServiceController {

    private final SubscriptionService subscriptionService;
    private final ConversionService converter;

    @Override
    @PostMapping
    public ResponseEntity<SubscriptionResponseDto> createSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        log.info("ServiceControllerImpl#createSubscription(" + subscriptionRequestDto + ")");
        Subscription subscription = converter.convert(subscriptionRequestDto, Subscription.class);
        Subscription saved = subscriptionService.save(subscription);
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(saved, SubscriptionResponseDto.class));
    }

    @Override
    @PutMapping()
    public ResponseEntity<SubscriptionResponseDto> updateSubscription(@RequestBody SubscriptionRequestDto subscriptionRequestDto) {
        log.info("ServiceControllerImpl#updateSubscription(" + subscriptionRequestDto + ")");
        Subscription subscription = converter.convert(subscriptionRequestDto, Subscription.class);
        Subscription updated = subscriptionService.update(subscription);
        return ResponseEntity.ok().body(converter.convert(updated, SubscriptionResponseDto.class));
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
        log.info("ServiceControllerImpl#deleteSubscription(" + id + ")");
        subscriptionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<SubscriptionResponseDto> getSubscription(@PathVariable Long id) {
        log.info("ServiceControllerImpl#getSubscription(" + id + ")");
        Subscription subscription = subscriptionService.get(id);
        return ResponseEntity.ok().body(converter.convert(subscription, SubscriptionResponseDto.class));
    }

    @Override
    @GetMapping
    public ResponseEntity<Page<SubscriptionResponseDto>> getAllSubscription(@PageableDefault Pageable pageable) {
        log.info("ServiceControllerImpl#getAllSubscription(" + pageable + ")");
        Page<SubscriptionResponseDto> dtoPage = subscriptionService.getAll(pageable)
                .map(subscription -> converter.convert(subscription, SubscriptionResponseDto.class));
        return ResponseEntity.ok().body(dtoPage);
    }
}
