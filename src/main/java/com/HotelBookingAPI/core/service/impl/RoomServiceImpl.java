package com.HotelBookingAPI.core.service.impl;

import com.HotelBookingAPI.core.exception.HotelNotFoundException;
import com.HotelBookingAPI.core.exception.RoomNotFoundException;
import com.HotelBookingAPI.core.service.RoomService;
import com.HotelBookingAPI.dataprovider.database.entity.HotelEntity;
import com.HotelBookingAPI.dataprovider.database.entity.RoomEntity;
import com.HotelBookingAPI.dataprovider.database.repository.HotelRepository;
import com.HotelBookingAPI.dataprovider.database.repository.RoomRepository;
import com.HotelBookingAPI.entrypoint.api.dto.request.RoomRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoomServiceImpl implements RoomService {

    private final HotelRepository hotelRepository;
    private final RoomRepository roomRepository;

    public RoomServiceImpl(HotelRepository hotelRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public void createRoom(RoomRequest request) {
        var room = toEntity(request);
        roomRepository.save(room);
    }

    @Override
    public void updateRoom(UUID roomId, RoomRequest roomRequest) {
        var hotel = hotelRepository.findById(roomRequest.hotelId()).orElseThrow(HotelNotFoundException::new);
        var room = roomRepository.findById(roomId).orElseThrow(RoomNotFoundException::new);

        room.setHotel(hotel);
        room.setNumber(roomRequest.number());
        room.setPrice(roomRequest.price());
        room.setStatus(roomRequest.status());

        roomRepository.save(room);
    }

    @Override
    public List<RoomEntity> getAllRooms() {
        return roomRepository.findAll();
    }

    @Override
    public RoomEntity getRoomById(UUID roomId) {
        return roomRepository.findById(roomId).orElseThrow(RoomNotFoundException::new);
    }

    private RoomEntity toEntity(RoomRequest roomRequest) {
        var hotel = hotelRepository.findById(roomRequest.hotelId()).orElseThrow(RoomNotFoundException::new);

        return RoomEntity.builder()
                .hotel(hotel)
                .number(roomRequest.number())
                .status(roomRequest.status())
                .price(roomRequest.price())
                .build();
    }
}
