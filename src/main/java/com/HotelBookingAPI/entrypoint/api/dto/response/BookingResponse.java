package com.HotelBookingAPI.entrypoint.api.dto.response;

import lombok.Builder;

import java.time.LocalDate;
import java.util.UUID;

@Builder
public record BookingResponse(
        UUID id,
        UUID clientId,
        UUID roomId,
        LocalDate checkIn,
        LocalDate checkOut
) {
}
