package com.HotelBookingAPI.core.service;

import com.HotelBookingAPI.dataprovider.database.entity.BookingEntity;
import com.HotelBookingAPI.entrypoint.api.dto.request.BookingRequest;

import java.util.List;
import java.util.UUID;

public interface BookingService {

    void createBooking(BookingRequest booking);

    void updateBooking(UUID bookingId, BookingRequest booking);

    BookingEntity getBookingById(UUID booking);

    List<BookingEntity> getAllBookings();
}
