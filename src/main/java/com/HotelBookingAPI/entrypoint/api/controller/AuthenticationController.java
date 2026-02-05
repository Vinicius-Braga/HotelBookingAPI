package com.HotelBookingAPI.entrypoint.api.controller;

import com.HotelBookingAPI.entrypoint.api.dto.request.AuthenticationRequest;
import com.HotelBookingAPI.entrypoint.api.dto.request.RegisterRequest;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/auth")
public interface AuthenticationController {

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationRequest request);

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterRequest request);

}
