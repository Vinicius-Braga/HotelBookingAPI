package com.HotelBookingAPI.entrypoint.api.controller;

import java.util.List;
import java.util.UUID;

import com.HotelBookingAPI.entrypoint.api.dto.request.BookingRequest;
import com.HotelBookingAPI.entrypoint.api.dto.response.BookingResponse;
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


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@Validated
@RequestMapping("/booking")
public interface BookingController {

    @Operation(tags = "booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrived bookings."),
            @ApiResponse(responseCode = "404", description = "Bookings not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    ResponseEntity<List<BookingResponse>> getAllBookings();

    @Operation(tags = "booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrived booking."),
            @ApiResponse(responseCode = "404", description = "booking not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{bookingId}")
    ResponseEntity<BookingResponse> getBookingById(@PathVariable UUID bookingId);

    @Operation(tags = "booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created booking."),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ResponseEntity<String> createBooking(@RequestBody BookingRequest request);

    @Operation(tags = "booking")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated booking."),
            @ApiResponse(responseCode = "404", description = "Booking not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{bookingId}")
    ResponseEntity<String> updateBooking(@PathVariable UUID bookingId,
                                        @RequestBody BookingRequest request);


}
