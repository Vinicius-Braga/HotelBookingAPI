package com.HotelBookingAPI.entrypoint.api.controller;

import com.HotelBookingAPI.entrypoint.api.dto.request.ClientRequest;
import com.HotelBookingAPI.entrypoint.api.dto.response.ClientResponse;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.UUID;

@Validated
@RequestMapping("/client")
public interface ClientController {

    @Operation(tags = "client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrived clients."),
            @ApiResponse(responseCode = "404", description = "Clients not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping
    ResponseEntity<List<ClientResponse>> getAllClients();

    @Operation(tags = "client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully retrived client."),
            @ApiResponse(responseCode = "404", description = "Client not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{clientId}")
    ResponseEntity<ClientResponse> getClientById(@PathVariable UUID clientId);

    @Operation(tags = "client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully created client."),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    ResponseEntity<String> createClient(@RequestBody ClientRequest request);

    @Operation(tags = "client")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Successfully updated client."),
            @ApiResponse(responseCode = "404", description = "Client not found.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Unable to process.", content = {@Content(mediaType = "application/json", schema = @Schema(implementation = ErrorResponse.class))})
    })
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/{clientId}")
    ResponseEntity<String> updateClient(@PathVariable UUID clientId,
                                        @RequestBody ClientRequest request);
}
