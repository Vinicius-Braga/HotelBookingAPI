package com.HotelBookingAPI.entrypoint.api.dto.request;

public record AuthenticationRequest(
        String email,
        String password
) {
}
