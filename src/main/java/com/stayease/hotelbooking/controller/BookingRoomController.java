
package com.stayease.hotelbooking.controller;

import com.stayease.hotelbooking.entity.BookingRoom;
import com.stayease.hotelbooking.entity.BookingRoomId;
import com.stayease.hotelbooking.service.BookingRoomService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/booking-rooms")
@CrossOrigin(origins = "*")
public class BookingRoomController {

    private final BookingRoomService bookingRoomService;

    public BookingRoomController(BookingRoomService bookingRoomService) {
        this.bookingRoomService = bookingRoomService;
    }

    @GetMapping
    public List<BookingRoom> getAllAllocations() {
        return bookingRoomService.getAllAllocations();
    }

    @GetMapping("/booking/{bookingId}")
    public List<BookingRoom> getRoomsByBooking(@PathVariable Integer bookingId) {
        return bookingRoomService.getRoomsByBooking(bookingId);
    }

    @GetMapping("/room/{roomId}")
    public List<BookingRoom> getBookingsByRoom(@PathVariable Integer roomId) {
        return bookingRoomService.getBookingsByRoom(roomId);
    }

    @PostMapping
    public BookingRoom createAllocation(@RequestBody BookingRoom allocation) {
        return bookingRoomService.saveAllocation(allocation);
    }

    @DeleteMapping("/{bookingId}/{roomId}")
    public ResponseEntity<Void> deleteAllocation(
            @PathVariable Integer bookingId,
            @PathVariable Integer roomId) {

        BookingRoomId id = new BookingRoomId(bookingId, roomId);
        bookingRoomService.deleteAllocation(id);

        return ResponseEntity.noContent().build();
    }
}
