package com.HotelBookingAPI.core.service.impl;

import com.HotelBookingAPI.core.exception.UserNotFoundException;
import com.HotelBookingAPI.core.service.UserService;
import com.HotelBookingAPI.dataprovider.database.entity.UserEntity;
import com.HotelBookingAPI.dataprovider.database.repository.UserRepository;
import com.HotelBookingAPI.entrypoint.api.dto.request.UserRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void createUser(UserRequest user) {
        var userEntity = toEntity(user);

        userRepository.save(userEntity);
    }

    @Override
    public void updateUser(UUID userId, UserRequest user) {
        var userEntity = userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);

        userEntity.setName(user.name());
        userEntity.setEmail(user.email());
        userEntity.setDocument(user.document());

        userRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity getUserById(UUID userId) {
        return userRepository.findById(userId)
                .orElseThrow(UserNotFoundException::new);
    }


    public static UserEntity toEntity(UserRequest request) {
        return UserEntity.builder()
                .name(request.name())
                .email(request.email())
                .document(request.document())
                .build();
    }
}
