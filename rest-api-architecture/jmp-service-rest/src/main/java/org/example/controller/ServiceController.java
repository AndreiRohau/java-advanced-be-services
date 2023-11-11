package org.example.controller;

import org.example.dto.SubscriptionRequestDto;
import org.example.dto.SubscriptionResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface ServiceController {
    ResponseEntity<SubscriptionResponseDto> createSubscription(SubscriptionRequestDto subscriptionRequestDto); // id is always null
    ResponseEntity<SubscriptionResponseDto> updateSubscription(SubscriptionRequestDto subscriptionRequestDto); // id is used for updating process
    ResponseEntity<Void> deleteSubscription(Long subscriptionId);
    ResponseEntity<SubscriptionResponseDto> getSubscription(Long subscriptionId);
    ResponseEntity<Page<SubscriptionResponseDto>> getAllSubscription(Pageable pageable);
}
