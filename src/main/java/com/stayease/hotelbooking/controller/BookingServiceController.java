package com.stayease.hotelbooking.controller;

import com.stayease.hotelbooking.entity.BookingService;
import com.stayease.hotelbooking.service.BookingServiceManager;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/booking-services")
public class BookingServiceController {

    private final BookingServiceManager bookingServiceManager;

    public BookingServiceController(BookingServiceManager bookingServiceManager) {
        this.bookingServiceManager = bookingServiceManager;
    }

    @GetMapping
    public List<BookingService> getAllBookingServices() {
        return bookingServiceManager.getAllBookingServices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingService> getBookingServiceById(@PathVariable Integer id) {
        return bookingServiceManager.getBookingServiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/booking/{bookingId}")
    public List<BookingService> getServicesByBooking(@PathVariable Integer bookingId) {
        return bookingServiceManager.getServicesByBooking(bookingId);
    }

    @GetMapping("/service/{serviceId}")
    public List<BookingService> getBookingsByService(@PathVariable Integer serviceId) {
        return bookingServiceManager.getBookingsByService(serviceId);
    }

    @PostMapping
    public BookingService createBookingService(@Valid @RequestBody BookingService bookingService) {
        return bookingServiceManager.saveBookingService(bookingService);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookingService(@PathVariable Integer id) {
        bookingServiceManager.deleteBookingService(id);
        return ResponseEntity.noContent().build();
    }
}