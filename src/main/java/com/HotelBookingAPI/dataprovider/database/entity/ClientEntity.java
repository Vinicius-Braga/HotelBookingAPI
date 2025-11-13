package com.HotelBookingAPI.dataprovider.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name = "client")
@AllArgsConstructor
public class ClientEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    private String email;

    private String document;

    public ClientEntity() {

    }
}
