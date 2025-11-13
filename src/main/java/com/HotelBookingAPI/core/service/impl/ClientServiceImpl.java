package com.HotelBookingAPI.core.service.impl;

import com.HotelBookingAPI.core.exception.ClientNotFoundException;
import com.HotelBookingAPI.core.service.ClientService;
import com.HotelBookingAPI.dataprovider.database.entity.ClientEntity;
import com.HotelBookingAPI.dataprovider.database.repository.ClientRepository;
import com.HotelBookingAPI.entrypoint.api.dto.request.ClientRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public void createClient(ClientRequest client) {
        var clientEntity = toEntity(client);

        clientRepository.save(clientEntity);
    }

    @Override
    public void updateClient(UUID clientId, ClientRequest client) {
        var clientEntity = clientRepository.findById(clientId)
                .orElseThrow(ClientNotFoundException::new);

        clientEntity.setName(client.name());
        clientEntity.setEmail(client.email());
        clientEntity.setDocument(client.document());

        clientRepository.save(clientEntity);
    }

    @Override
    public List<ClientEntity> getClients() {
        return clientRepository.findAll();
    }

    @Override
    public ClientEntity getClientById(UUID clientId) {
        return clientRepository.findById(clientId)
                .orElseThrow(ClientNotFoundException::new);
    }


    public static ClientEntity toEntity(ClientRequest request) {
        return ClientEntity.builder()
                .name(request.name())
                .email(request.email())
                .document(request.document())
                .build();
    }
}
