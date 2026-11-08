
package com.stayease.hotelbooking.service;

import com.stayease.hotelbooking.entity.BookingRoom;
import com.stayease.hotelbooking.entity.BookingRoomId;
import com.stayease.hotelbooking.repository.BookingRoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingRoomService {

    private final BookingRoomRepository bookingRoomRepository;

    public BookingRoomService(BookingRoomRepository bookingRoomRepository) {
        this.bookingRoomRepository = bookingRoomRepository;
    }

    public List<BookingRoom> getAllAllocations() {
        return bookingRoomRepository.findAll();
    }

    public Optional<BookingRoom> getAllocationById(BookingRoomId id) {
        return bookingRoomRepository.findById(id);
    }

    public List<BookingRoom> getRoomsByBooking(Integer bookingId) {
        return bookingRoomRepository.findByBooking_BookingId(bookingId);
    }

    public List<BookingRoom> getBookingsByRoom(Integer roomId) {
        return bookingRoomRepository.findByRoom_RoomId(roomId);
    }

    public BookingRoom saveAllocation(BookingRoom allocation) {
        return bookingRoomRepository.save(allocation);
    }

    public void deleteAllocation(BookingRoomId id) {
        bookingRoomRepository.deleteById(id);
    }
}
