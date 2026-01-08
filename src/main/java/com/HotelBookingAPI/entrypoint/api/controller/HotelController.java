package com.HotelBookingAPI.entrypoint.api.controller;

import com.HotelBookingAPI.entrypoint.api.dto.request.ClientRequest;
import com.HotelBookingAPI.entrypoint.api.dto.request.HotelRequest;
import com.HotelBookingAPI.entrypoint.api.dto.response.ClientResponse;
import com.HotelBookingAPI.entrypoint.api.dto.response.HotelResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;

@RequestMapping("hotel")
public interface HotelController {


    @Operation(tags = "hotel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrived hotels."),
            @ApiResponse(responseCode = "404", description = "HotelS not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    ResponseEntity<List<HotelResponse>> getAllHotels();

    @Operation(tags = "hotel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrived hotel."),
            @ApiResponse(responseCode = "404", description = "Hotel not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{hotelId}")
    ResponseEntity<HotelResponse> getHotelById(@PathVariable UUID hotelId);

    @Operation(tags = "hotel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created hotel."),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ResponseEntity<String> createHotel(@RequestBody HotelRequest request);

    @Operation(tags = "hotel")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated hotel."),
            @ApiResponse(responseCode = "404", description = "Hotel not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{hotelId}")
    ResponseEntity<String> updateHotel(@PathVariable UUID hotelId,
                                        @RequestBody HotelRequest request);
}