package org.example.service;

import org.example.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface UserService {
    User save(User user); // id is always null
    User update(User user); // id is used for updating process
    void delete(Long id);
    User get(Long id);
    Page<User> getAll(Pageable pageable);
}
