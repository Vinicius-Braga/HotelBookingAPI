package com.HotelBookingAPI.core.exception;

public class RoomNotFoundException extends RuntimeException {
    private static final String MASSAGE = "Oops! Room not found!";

    public RoomNotFoundException() {
        super(MASSAGE);
    }
}
