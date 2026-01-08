package com.HotelBookingAPI.core.exception;

public class BookingNotFoundException extends RuntimeException {
    private static final String MASSAGE = "Oops! Booking not found!";

    public BookingNotFoundException() {
        super(MASSAGE);
    }
}
