package com.HotelBookingAPI.core.service.impl;

import com.HotelBookingAPI.core.exception.ClientNotFoundException;
import com.HotelBookingAPI.core.exception.HotelNotFoundException;
import com.HotelBookingAPI.core.service.HotelService;
import com.HotelBookingAPI.dataprovider.database.entity.HotelEntity;
import com.HotelBookingAPI.dataprovider.database.repository.HotelRepository;
import com.HotelBookingAPI.entrypoint.api.dto.request.ClientRequest;
import com.HotelBookingAPI.entrypoint.api.dto.request.HotelRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;

    public HotelServiceImpl(HotelRepository hotelRepository) {
        this.hotelRepository = hotelRepository;
    }

    @Override
    public void createHotel(HotelRequest request) {
        var hotelEntity = toEntity(request);

        hotelRepository.save(hotelEntity);
    }

    @Override
    public void updateHotel(UUID clientId, HotelRequest request) {
        var hotelEntity = hotelRepository.findById(clientId).orElseThrow(HotelNotFoundException::new);

        hotelEntity.setName(request.name());
        hotelEntity.setAddress(request.address());

        hotelRepository.save(hotelEntity);
    }

    @Override
    public List<HotelEntity> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public HotelEntity getHotelById(UUID hotelId) {
        return hotelRepository.findById(hotelId).orElseThrow(HotelNotFoundException::new);
    }

    private HotelEntity toEntity(HotelRequest request) {
        return HotelEntity.builder()
                .name(request.name())
                .address(request.address())
                .build();
    }
}
