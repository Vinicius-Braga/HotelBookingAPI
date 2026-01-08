package com.HotelBookingAPI.entrypoint.api.dto.response;

import com.HotelBookingAPI.core.domain.enums.RoomStatus;
import lombok.Builder;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
public record RoomResponse(
        UUID id,
        UUID hotelId,
        Long number,
        RoomStatus status,
        BigDecimal price
) {
}
