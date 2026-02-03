package com.HotelBookingAPI.core.service.impl;

import com.HotelBookingAPI.core.exception.BookingNotFoundException;
import com.HotelBookingAPI.core.exception.ClientNotFoundException;
import com.HotelBookingAPI.core.exception.RoomNotFoundException;
import com.HotelBookingAPI.core.service.BookingService;
import com.HotelBookingAPI.dataprovider.database.entity.BookingEntity;
import com.HotelBookingAPI.dataprovider.database.repository.BookingRepository;
import com.HotelBookingAPI.dataprovider.database.repository.ClientRepository;
import com.HotelBookingAPI.dataprovider.database.repository.RoomRepository;
import com.HotelBookingAPI.entrypoint.api.dto.request.BookingRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final ClientRepository clientRepository;

    public BookingServiceImpl(BookingRepository bookingRepository,
                              RoomRepository roomRepository,
                              ClientRepository clientRepository) {
        this.bookingRepository = bookingRepository;
        this.roomRepository = roomRepository;
        this.clientRepository = clientRepository;
    }

    @Override
    public void createBooking(BookingRequest bookingRequest) {
        var booking = toEntity(bookingRequest);
        bookingRepository.save(booking);
    }

    @Override
    public void updateBooking(UUID bookingId, BookingRequest bookingRequest) {
        var booking = bookingRepository.findById(bookingId).orElseThrow(BookingNotFoundException::new);
        var client = clientRepository.findById(bookingRequest.clientId()).orElseThrow(ClientNotFoundException::new);
        var room = roomRepository.findById(bookingRequest.roomId()).orElseThrow(RoomNotFoundException::new);

        booking.setRoom(room);
        booking.setClient(client);
        booking.setCheckIn(bookingRequest.checkIn());
        booking.setCheckOut(bookingRequest.checkOut());

        bookingRepository.save(booking);
    }

    @Override
    public BookingEntity getBookingById(UUID bookingId) {
        return bookingRepository.findById(bookingId).orElseThrow(BookingNotFoundException::new);
    }

    @Override
    public List<BookingEntity> getAllBookings() {
        return bookingRepository.findAll();
    }

    private BookingEntity toEntity(BookingRequest booking) {
        var room = roomRepository.findById(booking.roomId()).orElseThrow(RoomNotFoundException::new);
        var client =  clientRepository.findById(booking.clientId()).orElseThrow(ClientNotFoundException::new);

        return BookingEntity.builder()
                .room(room)
                .client(client)
                .checkIn(booking.checkIn())
                .checkOut(booking.checkOut())
                .build();
    }

}
