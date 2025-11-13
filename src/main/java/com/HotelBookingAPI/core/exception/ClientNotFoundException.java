package com.HotelBookingAPI.core.exception;

public class ClientNotFoundException extends RuntimeException {

    private static final String MASSAGE = "Oops! Client not found!";

    public ClientNotFoundException() {
        super(MASSAGE);
    }
}
