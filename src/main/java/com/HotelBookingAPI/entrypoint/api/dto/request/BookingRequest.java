package com.HotelBookingAPI.entrypoint.api.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public record BookingRequest(
        UUID userId,
        UUID roomId,
        LocalDate checkIn,
        LocalDate checkOut
) {
}
