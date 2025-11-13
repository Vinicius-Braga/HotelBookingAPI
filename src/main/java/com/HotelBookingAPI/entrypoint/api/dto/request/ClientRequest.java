package com.HotelBookingAPI.entrypoint.api.dto.request;

public record ClientRequest (
    String name,
    String email,
    String document
){
}
