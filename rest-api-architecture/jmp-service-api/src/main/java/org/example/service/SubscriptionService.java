package org.example.service;

import org.example.entity.Subscription;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface SubscriptionService {
    Subscription save(Subscription subscription); // id is always null
    Subscription update(Subscription subscription); // id is used for updating process
    void delete(Long id);
    Subscription get(Long id);
    Page<Subscription> getAll(Pageable pageable);
}
