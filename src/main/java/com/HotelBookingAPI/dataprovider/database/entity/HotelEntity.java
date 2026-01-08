package com.HotelBookingAPI.dataprovider.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name = "hotel")
@NoArgsConstructor
@AllArgsConstructor
public class HotelEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    private String name;

    private String address;

}
