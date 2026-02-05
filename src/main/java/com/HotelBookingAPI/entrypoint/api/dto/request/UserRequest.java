package com.HotelBookingAPI.entrypoint.api.dto.request;

public record UserRequest(
    String name,
    String email,
    String document
){
}
