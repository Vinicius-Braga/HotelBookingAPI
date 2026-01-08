package com.HotelBookingAPI.entrypoint.api.dto.request;

import com.HotelBookingAPI.core.domain.enums.RoomStatus;

import java.math.BigDecimal;
import java.util.UUID;

public record RoomRequest(
    Long number,
    BigDecimal price,
    RoomStatus status,
    UUID hotelId
) {
}
