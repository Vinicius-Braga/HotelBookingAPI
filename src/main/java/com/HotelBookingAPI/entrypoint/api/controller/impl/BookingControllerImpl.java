package com.HotelBookingAPI.entrypoint.api.controller.impl;

import com.HotelBookingAPI.core.service.BookingService;
import com.HotelBookingAPI.entrypoint.api.controller.BookingController;
import com.HotelBookingAPI.entrypoint.api.dto.request.BookingRequest;
import com.HotelBookingAPI.entrypoint.api.dto.response.BookingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class BookingControllerImpl implements BookingController {

    private final BookingService bookingService;

    public BookingControllerImpl(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public ResponseEntity<List<BookingResponse>> getAllBookings() {
        var bookings = bookingService.getAllBookings();

        var response = bookings.stream().map(
                booking -> BookingResponse.builder()
                        .id(booking.getId())
                        .clientId(booking.getClient().getId())
                        .roomId(booking.getRoom().getId())
                        .checkIn(booking.getCheckIn())
                        .checkOut(booking.getCheckOut())
                        .build()
        ).toList();

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<BookingResponse> getBookingById(UUID bookingId) {
        var bookings = bookingService.getBookingById(bookingId);

        var response =  BookingResponse.builder()
                        .id(bookings.getId())
                        .clientId(bookings.getClient().getId())
                        .roomId(bookings.getRoom().getId())
                        .checkIn(bookings.getCheckIn())
                        .checkOut(bookings.getCheckOut())
                        .build();

        return ResponseEntity.ok(response);
    }

    @Override
    public ResponseEntity<String> createBooking(BookingRequest request) {
        bookingService.createBooking(request);

        return ResponseEntity.ok("Booking created successfully");
    }

    @Override
    public ResponseEntity<String> updateBooking(UUID bookingId, BookingRequest request) {
        bookingService.updateBooking(bookingId, request);

        return ResponseEntity.ok("Booking updated successfully");
    }
}
