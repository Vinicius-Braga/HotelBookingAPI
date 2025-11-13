package com.HotelBookingAPI.core.service;

import com.HotelBookingAPI.dataprovider.database.entity.ClientEntity;
import com.HotelBookingAPI.entrypoint.api.dto.request.ClientRequest;

import java.util.List;
import java.util.UUID;

public interface ClientService {

    void createClient(ClientRequest client);

    void updateClient(UUID clientId,ClientRequest client);

    List<ClientEntity> getClients();

    ClientEntity getClientById(UUID clientId);
}
