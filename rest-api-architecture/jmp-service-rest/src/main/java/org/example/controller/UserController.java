package org.example.controller;

import org.example.dto.UserRequestDto;
import org.example.dto.UserResponseDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;

public interface UserController {
    ResponseEntity<UserResponseDto> createUser(UserRequestDto userRequestDto); // id is always null
    ResponseEntity<UserResponseDto> updateUser(UserRequestDto userRequestDto); // id is used for updating process
    ResponseEntity<Void> deleteUser(Long userId);
    ResponseEntity<UserResponseDto> getUser(Long userId);
    ResponseEntity<Page<UserResponseDto>> getAllUser(Pageable pageable);
}
