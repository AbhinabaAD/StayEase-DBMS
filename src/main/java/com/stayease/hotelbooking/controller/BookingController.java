
package com.stayease.hotelbooking.controller;

import com.stayease.hotelbooking.entity.Booking;
import com.stayease.hotelbooking.service.BookingService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/api/bookings")
@CrossOrigin(origins = "*")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @GetMapping
    public List<Booking> getAllBookings() {
        return bookingService.getAllBookings();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Integer id) {
        return bookingService.getBookingById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public List<Booking> getBookingsByCustomer(@PathVariable Integer customerId) {
        return bookingService.getBookingsByCustomer(customerId);
    }

    @GetMapping("/branch/{branchId}")
    public List<Booking> getBookingsByBranch(@PathVariable Integer branchId) {
        return bookingService.getBookingsByBranch(branchId);
    }

    @GetMapping("/status/{status}")
    public List<Booking> getBookingsByStatus(@PathVariable String status) {
        return bookingService.getBookingsByStatus(status);
    }

    @PostMapping
    public Booking createBooking(@Valid @RequestBody Booking booking) {
        return bookingService.saveBooking(booking);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable Integer id) {
        bookingService.deleteBooking(id);
        return ResponseEntity.noContent().build();
    }
}
