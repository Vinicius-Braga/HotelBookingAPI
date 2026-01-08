package com.HotelBookingAPI.entrypoint.api.controller.impl;

import com.HotelBookingAPI.core.service.RoomService;
import com.HotelBookingAPI.entrypoint.api.controller.RoomController;
import com.HotelBookingAPI.entrypoint.api.dto.request.RoomRequest;
import com.HotelBookingAPI.entrypoint.api.dto.response.RoomResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class RoomControllerImpl implements RoomController {

    private final RoomService roomService;

    public RoomControllerImpl(RoomService roomService) {
        this.roomService = roomService;
    }

    @Override
    public ResponseEntity<List<RoomResponse>> getAllRooms() {
        var rooms = roomService.getAllRooms();

        var response = rooms.stream()
                .map(room -> RoomResponse.builder()
                        .id(room.getId())
                        .Hotel(room.getHotel().getId())
                        .number(room.getNumber())
                        .price(room.getPrice())
                        .status(room.getStatus())
                        .build()
                ).toList();


        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<RoomResponse> getRoomById(UUID roomId) {
        var room = roomService.getRoomById(roomId);

        var response = RoomResponse.builder()
                .id(room.getId())
                .Hotel(room.getHotel().getId())
                .number(room.getNumber())
                .price(room.getPrice())
                .status(room.getStatus())
                .build();


        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<String> createRoom(RoomRequest request) {
        roomService.createRoom(request);

        return ResponseEntity.ok("Room created successfully");
    }

    @Override
    public ResponseEntity<String> updateRoom(UUID roomId, RoomRequest request) {
        roomService.updateRoom(roomId, request);
        return ResponseEntity.ok("Room updated successfully");
    }
}
