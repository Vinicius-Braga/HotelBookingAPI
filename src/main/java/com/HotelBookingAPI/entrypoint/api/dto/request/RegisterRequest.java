package com.HotelBookingAPI.entrypoint.api.dto.request;

import com.HotelBookingAPI.core.domain.enums.UserRoles;

public record RegisterRequest(
        String name,
        String email,
        String password,
        String document,
        UserRoles role
) {
}
