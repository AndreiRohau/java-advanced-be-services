package org.example.service;

import lombok.RequiredArgsConstructor;
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

@Service
@RequiredArgsConstructor
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        userRepository.findById(user.getId())
                .orElseThrow(() -> new CustomException("User not found, id=" + user.getId(), HttpStatus.NOT_FOUND));
        return userRepository.save(user);
    }

    @Override
    public void delete(Long id) {
        subscriptionRepository.deleteAllByUserId(id);
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException ex) {
            throw new CustomException("User not found, id=" + id, HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public User get(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found, id=" + id, HttpStatus.NOT_FOUND));
    }

    @Override
    public Page<User> getAll(Pageable pageable) {
        return userRepository.findAll(pageable);
    }
}
