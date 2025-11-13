package com.HotelBookingAPI.entrypoint.api.controller.impl;

import com.HotelBookingAPI.core.service.ClientService;
import com.HotelBookingAPI.entrypoint.api.controller.ClientController;
import com.HotelBookingAPI.entrypoint.api.dto.request.ClientRequest;
import com.HotelBookingAPI.entrypoint.api.dto.response.ClientResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ClientControllerImpl implements ClientController {

    private final ClientService clientService;

    public ClientControllerImpl(ClientService clientService) {
        this.clientService = clientService;
    }

    @Override
    public ResponseEntity<List<ClientResponse>> getAllClients() {
        var clients = clientService.getClients();

        var clientsResponse = clients.stream()
                .map(client ->  ClientResponse.builder()
                        .id(client.getId())
                        .name(client.getName())
                        .email(client.getEmail())
                        .document(client.getDocument())
                        .build()
                ).toList();


        return ResponseEntity.ok(clientsResponse);
    }

    @Override
    public ResponseEntity<ClientResponse> getClientById(UUID clientId) {
        var client = clientService.getClientById(clientId);

        var clientResponse = ClientResponse.builder()
                .id(client.getId())
                .name(client.getName())
                .email(client.getEmail())
                .document(client.getDocument())
                .build();

        return ResponseEntity.ok(clientResponse);
    }

    @Override
    public ResponseEntity<String> createClient(ClientRequest request) {
        clientService.createClient(request);

        return ResponseEntity.ok("Yes! Client created successfully");
    }

    @Override
    public ResponseEntity<String> updateClient(UUID clientId, ClientRequest request) {
        clientService.updateClient(clientId, request);

        return ResponseEntity.ok("Yes! Client updated successfully");
    }
}
