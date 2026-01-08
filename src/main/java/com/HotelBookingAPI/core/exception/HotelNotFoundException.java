package com.HotelBookingAPI.core.exception;

public class HotelNotFoundException extends RuntimeException {
    private static final String MASSAGE = "Oops! Hotel not found!";

    public HotelNotFoundException() {
        super(MASSAGE);
    }
}
