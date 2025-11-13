package com.HotelBookingAPI.dataprovider.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "booking")
public class BookingEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @OneToOne
    private RoomEntity room;

    @ManyToOne
    private ClientEntity client;

    private LocalDateTime check_in;

    private LocalDateTime check_out;
}
