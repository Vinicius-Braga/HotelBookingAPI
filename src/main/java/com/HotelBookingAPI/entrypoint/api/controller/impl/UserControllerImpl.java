package com.HotelBookingAPI.entrypoint.api.controller.impl;

import com.HotelBookingAPI.core.service.UserService;
import com.HotelBookingAPI.entrypoint.api.controller.UserController;
import com.HotelBookingAPI.entrypoint.api.dto.request.UserRequest;
import com.HotelBookingAPI.entrypoint.api.dto.response.UserResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class UserControllerImpl implements UserController {

    private final UserService userService;

    public UserControllerImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        var users = userService.getUsers();

        var usersResponse = users.stream()
                .map(user ->  UserResponse.builder()
                        .id(user.getId())
                        .name(user.getName())
                        .email(user.getEmail())
                        .document(user.getDocument())
                        .build()
                ).toList();


        return ResponseEntity.ok(usersResponse);
    }

    @Override
    public ResponseEntity<UserResponse> getUserById(UUID userId) {
        var user = userService.getUserById(userId);

        var userResponse = UserResponse.builder()
                .id(user.getId())
                .name(user.getName())
                .email(user.getEmail())
                .document(user.getDocument())
                .build();

        return ResponseEntity.ok(userResponse);
    }

    @Override
    public ResponseEntity<String> createUser(UserRequest request) {
        userService.createUser(request);

        return ResponseEntity.ok("Yes! User created successfully");
    }

    @Override
    public ResponseEntity<String> updateUser(UUID userId, UserRequest request) {
        userService.updateUser(userId, request);

        return ResponseEntity.ok("Yes! User updated successfully");
    }
}
