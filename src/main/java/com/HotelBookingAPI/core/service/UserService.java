package com.HotelBookingAPI.core.service;

import com.HotelBookingAPI.dataprovider.database.entity.UserEntity;
import com.HotelBookingAPI.entrypoint.api.dto.request.UserRequest;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void createUser(UserRequest user);

    void updateUser(UUID userId,UserRequest user);

    List<UserEntity> getUsers();

    UserEntity getUserById(UUID userId);
}
