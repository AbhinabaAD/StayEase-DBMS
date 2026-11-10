package com.stayease.hotelbooking.service;

import com.stayease.hotelbooking.entity.BookingService;
import com.stayease.hotelbooking.repository.BookingServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceManager {

    private final BookingServiceRepository bookingServiceRepository;

    public BookingServiceManager(BookingServiceRepository bookingServiceRepository) {
        this.bookingServiceRepository = bookingServiceRepository;
    }

    public List<BookingService> getAllBookingServices() {
        return bookingServiceRepository.findAll();
    }

    public Optional<BookingService> getBookingServiceById(Integer id) {
        return bookingServiceRepository.findById(id);
    }

    public List<BookingService> getServicesByBooking(Integer bookingId) {
        return bookingServiceRepository.findByBooking_BookingId(bookingId);
    }

    public List<BookingService> getBookingsByService(Integer serviceId) {
        return bookingServiceRepository.findByService_ServiceId(serviceId);
    }

    public BookingService saveBookingService(BookingService bookingService) {
        return bookingServiceRepository.save(bookingService);
    }

    public void deleteBookingService(Integer id) {
        bookingServiceRepository.deleteById(id);
    }
}