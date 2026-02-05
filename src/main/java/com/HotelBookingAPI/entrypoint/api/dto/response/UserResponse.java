package com.HotelBookingAPI.entrypoint.api.dto.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record UserResponse(
        UUID id,
        String name,
        String email,
        String document
) {
}
