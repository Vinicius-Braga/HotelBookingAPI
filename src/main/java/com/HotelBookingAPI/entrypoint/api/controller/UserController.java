package com.HotelBookingAPI.entrypoint.api.controller;

import com.HotelBookingAPI.entrypoint.api.dto.request.UserRequest;
import com.HotelBookingAPI.entrypoint.api.dto.response.UserResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;

@Validated
@RequestMapping("/user")
public interface UserController {

    @Operation(tags = "user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrived users."),
            @ApiResponse(responseCode = "404", description = "Users not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    ResponseEntity<List<UserResponse>> getAllUsers();

    @Operation(tags = "user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrived user."),
            @ApiResponse(responseCode = "404", description = "User not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{userId}")
    ResponseEntity<UserResponse> getUserById(@PathVariable UUID userId);

    @Operation(tags = "user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created user."),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ResponseEntity<String> createUser(@RequestBody UserRequest request);

    @Operation(tags = "user")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated user."),
            @ApiResponse(responseCode = "404", description = "User not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{userId}")
    ResponseEntity<String> updateUser(@PathVariable UUID userId,
                                        @RequestBody UserRequest request);
}
