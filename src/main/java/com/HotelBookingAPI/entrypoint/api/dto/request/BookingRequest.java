package com.HotelBookingAPI.entrypoint.api.dto.request;

import java.time.LocalDate;
import java.util.UUID;

public record BookingRequest(
        UUID clientId,
        UUID roomId,
        LocalDate checkIn,
        LocalDate checkOut
) {
}
