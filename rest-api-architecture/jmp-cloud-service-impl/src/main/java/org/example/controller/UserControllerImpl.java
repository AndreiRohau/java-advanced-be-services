package org.example.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.example.dto.UserRequestDto;
import org.example.dto.UserResponseDto;
import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.core.convert.ConversionService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
@Log
public class UserControllerImpl implements UserController {

    private final UserService userService;
    private final ConversionService converter;

    @Operation(summary = "Create new user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Created new user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class)) })})
    @Override
    @PostMapping
    public ResponseEntity<UserResponseDto> createUser(@RequestBody UserRequestDto userRequestDto) {
        log.info("UserControllerImpl#createUser(" + userRequestDto + ")");
        User userFromDto = converter.convert(userRequestDto, User.class);
        User saved = userService.save(userFromDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(converter.convert(saved, UserResponseDto.class));
    }

    @Operation(summary = "Update existing user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Updated user",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @Override
    @PutMapping
    public ResponseEntity<UserResponseDto> updateUser(@RequestBody UserRequestDto userRequestDto) {
        log.info("UserControllerImpl#updateUser(" + userRequestDto + ")");
        User user = converter.convert(userRequestDto, User.class);
        User updated = userService.update(user);
        return ResponseEntity.ok().body(converter.convert(updated, UserResponseDto.class));
    }


    @Operation(summary = "Delete existing user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "204", description = "User not exists anymore",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = Void.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found",
                    content = @Content) })
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id) {
        log.info("UserControllerImpl#deleteUser(" + id + ")");
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Get existing user by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User found and returned",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class)) }),
            @ApiResponse(responseCode = "404", description = "User not found") })
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<UserResponseDto> getUser(@PathVariable Long id) {
        log.info("UserControllerImpl#getUser(" + id + ")");
        User user = userService.get(id);
        return ResponseEntity.ok().body(converter.convert(user, UserResponseDto.class));
    }

    @Operation(summary = "Get a page of users")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Page of users",
                    content = { @Content(mediaType = "application/json",
                            schema = @Schema(implementation = UserResponseDto.class)) })})
    @Override
    @GetMapping
    public ResponseEntity<Page<UserResponseDto>> getAllUser(@PageableDefault Pageable pageable) {
        log.info("UserControllerImpl#getAllUser(" + pageable + ")");
        Page<UserResponseDto> dtoPage = userService.getAll(pageable)
                .map(user -> converter.convert(user, UserResponseDto.class));
        return ResponseEntity.ok().body(dtoPage);
    }
}
