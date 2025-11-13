package com.HotelBookingAPI.dataprovider.database.repository;

import com.HotelBookingAPI.dataprovider.database.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoomRepository extends JpaRepository<RoomEntity, UUID> {
}
