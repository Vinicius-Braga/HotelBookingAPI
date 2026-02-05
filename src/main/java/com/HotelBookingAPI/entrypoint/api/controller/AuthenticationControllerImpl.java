package com.HotelBookingAPI.entrypoint.api.controller;

import com.HotelBookingAPI.dataprovider.database.entity.UserEntity;
import com.HotelBookingAPI.dataprovider.database.repository.UserRepository;
import com.HotelBookingAPI.entrypoint.api.dto.request.AuthenticationRequest;
import com.HotelBookingAPI.entrypoint.api.dto.request.RegisterRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthenticationControllerImpl implements AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

    public AuthenticationControllerImpl(AuthenticationManager authenticationManager, UserRepository userRepository) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
    }


    @Override
    public ResponseEntity login(AuthenticationRequest request) {
        var usernamePassword = new UsernamePasswordAuthenticationToken(request.email(), request.password());
        authenticationManager.authenticate(usernamePassword);

        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity register(RegisterRequest request) {
        if (this.userRepository.findByEmail(request.email()) != null) return ResponseEntity.badRequest().build();

        var encryptedPassword = new BCryptPasswordEncoder().encode(request.password());
        var newUser = new UserEntity(request.name() ,request.email(), encryptedPassword, request.document(), request.role());

        this.userRepository.save(newUser);

        return ResponseEntity.ok().build();
    }
}
