package com.HotelBookingAPI.core.exception;

public class UserNotFoundException extends RuntimeException {

    private static final String MASSAGE = "Oops! User not found!";

    public UserNotFoundException() {
        super(MASSAGE);
    }
}
