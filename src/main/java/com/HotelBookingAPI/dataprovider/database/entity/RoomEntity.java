package com.HotelBookingAPI.dataprovider.database.entity;

import com.HotelBookingAPI.core.domain.enums.RoomStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.UUID;

@Builder
@Getter
@Setter
@Entity
@Table(name = "room")
@NoArgsConstructor
@AllArgsConstructor
public class RoomEntity {

    @Id
    @GeneratedValue(generator = "UUID")
    private UUID id;

    @ManyToOne
    private HotelEntity hotel;

    private Long number;

    private RoomStatus status;

    private BigDecimal price;
}
