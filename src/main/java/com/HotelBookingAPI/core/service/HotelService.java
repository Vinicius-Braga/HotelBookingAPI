package com.HotelBookingAPI.core.service;

import com.HotelBookingAPI.dataprovider.database.entity.HotelEntity;
import com.HotelBookingAPI.entrypoint.api.dto.request.HotelRequest;

import java.util.List;
import java.util.UUID;

public interface HotelService {

    void createHotel(HotelRequest hotel);

    void updateHotel(UUID clientId, HotelRequest hotel);

    List<HotelEntity> getAllHotels();

    HotelEntity getHotelById(UUID hotelId);
}
