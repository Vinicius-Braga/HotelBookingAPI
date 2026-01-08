package com.HotelBookingAPI.core.service;

import com.HotelBookingAPI.dataprovider.database.entity.HotelEntity;
import com.HotelBookingAPI.dataprovider.database.entity.RoomEntity;
import com.HotelBookingAPI.entrypoint.api.dto.request.RoomRequest;

import java.util.List;
import java.util.UUID;

public interface RoomService {

    void createRoom(RoomRequest room);

    void updateRoom(UUID roomId, RoomRequest room);

    List<RoomEntity> getAllRooms();

    RoomEntity getRoomsById(UUID roomId);
}
