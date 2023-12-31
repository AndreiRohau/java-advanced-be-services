package org.example.service;

import lombok.RequiredArgsConstructor;
import org.example.entity.Subscription;
import org.example.entity.User;
import org.example.exception.CustomException;
import org.example.repository.SubscriptionRepository;
import org.example.repository.UserRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@RequiredArgsConstructor
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {

    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;

    @Override
    public Subscription save(Subscription subscription) {
        User user = userRepository.findById(subscription.getUser().getId())
                .orElseThrow(() -> new CustomException("User not found, id=" + subscription.getUser().getId(), HttpStatus.NOT_FOUND));
        return subscriptionRepository.save(Subscription.builder().user(user).startDate(LocalDate.now()).build());
    }

    @Override
    public Subscription update(Subscription subscription) {
        Subscription foundSubscription = subscriptionRepository.findById(subscription.getId())
                .orElseThrow(() -> new CustomException("Subscription not found, id=" + subscription.getId(), HttpStatus.NOT_FOUND));
        foundSubscription.setStartDate(LocalDate.now());
        return foundSubscription;
    }

    @Override
    public void delete(Long id) {
        try {
            subscriptionRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new CustomException("Subscription not found, id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Subscription get(Long id) {
        return subscriptionRepository.findById(id)
                .orElseThrow(() -> new CustomException("Subscription not found, id=" + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Page<Subscription> getAll(Pageable pageable) {
        return subscriptionRepository.findAll(pageable);
    }
}
