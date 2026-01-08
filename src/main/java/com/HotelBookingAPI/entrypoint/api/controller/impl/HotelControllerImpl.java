package com.HotelBookingAPI.entrypoint.api.controller.impl;

import com.HotelBookingAPI.core.service.HotelService;
import com.HotelBookingAPI.entrypoint.api.controller.HotelController;
import com.HotelBookingAPI.entrypoint.api.dto.request.HotelRequest;
import com.HotelBookingAPI.entrypoint.api.dto.response.HotelResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class HotelControllerImpl implements HotelController {

    private final HotelService hotelService;

    public HotelControllerImpl(HotelService hotelService) {
        this.hotelService = hotelService;
    }

    @Override
    public ResponseEntity<List<HotelResponse>> getAllHotels() {
        var hotels = hotelService.getAllHotels();

        var hotelResponse = hotels.stream()
                .map(hotel -> HotelResponse.builder()
                        .id(hotel.getId())
                        .name(hotel.getName())
                        .address(hotel.getAddress())
                        .build()
                ).toList();

        return ResponseEntity.ok(hotelResponse);
    }

    @Override
    public ResponseEntity<HotelResponse> getHotelById(UUID hotelId) {
        var hotel = hotelService.getHotelById(hotelId);

        var hotelResponse = HotelResponse.builder()
                .id(hotel.getId())
                .name(hotel.getName())
                .address(hotel.getAddress())
                .build();

        return ResponseEntity.ok(hotelResponse);
    }

    @Override
    public ResponseEntity<String> createHotel(HotelRequest request) {
        hotelService.createHotel(request);
        return ResponseEntity.ok("Hotel created successfully");
    }

    @Override
    public ResponseEntity<String> updateHotel(UUID hotelId, HotelRequest request) {
        hotelService.updateHotel(hotelId, request);
        return ResponseEntity.ok("Hotel updated successfully");
    }
}
