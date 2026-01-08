package com.HotelBookingAPI.entrypoint.api.dto.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record HotelResponse(
        UUID id,
        String name,
        String address
) {
}
