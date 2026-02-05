package com.HotelBookingAPI.core.domain.enums;

import lombok.Getter;

@Getter
public enum UserRoles {
    CLIENT("client"),
    ADMIN("admin");

    private final String role;

    UserRoles(String role) {
        this.role = role;
    }

}
