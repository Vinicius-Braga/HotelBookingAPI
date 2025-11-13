package com.HotelBookingAPI.entrypoint.api.dto.response;

import lombok.Builder;

import java.util.UUID;

@Builder
public record ClientResponse (
        UUID id,
        String name,
        String email,
        String document
) {
}
