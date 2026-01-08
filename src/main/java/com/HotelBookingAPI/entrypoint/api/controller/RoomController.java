package com.HotelBookingAPI.entrypoint.api.controller;

import com.HotelBookingAPI.entrypoint.api.dto.request.RoomRequest;
import com.HotelBookingAPI.entrypoint.api.dto.response.RoomResponse;
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

@RequestMapping("/room")
public interface RoomController {

    @Operation(tags = "room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved rooms."),
            @ApiResponse(responseCode = "404", description = "room not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    ResponseEntity<List<RoomResponse>> getAllRooms();

    @Operation(tags = "room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrieved room."),
            @ApiResponse(responseCode = "404", description = "Room not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{roomId}")
    ResponseEntity<RoomResponse> getRoomById(@PathVariable UUID roomId);

    @Operation(tags = "room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created room."),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ResponseEntity<String> createRoom(@RequestBody RoomRequest request);

    @Operation(tags = "room")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated room."),
            @ApiResponse(responseCode = "404", description = "Room not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{roomId}")
    ResponseEntity<String> updateRoom(@PathVariable UUID roomId,
                                       @RequestBody RoomRequest request);
}
