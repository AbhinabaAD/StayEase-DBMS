
package com.stayease.hotelbooking.service;

import com.stayease.hotelbooking.entity.Booking;
import com.stayease.hotelbooking.repository.BookingRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingService {

    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<Booking> getAllBookings() {
        return bookingRepository.findAll();
    }

    public Optional<Booking> getBookingById(Integer id) {
        return bookingRepository.findById(id);
    }

    public List<Booking> getBookingsByCustomer(Integer customerId) {
        return bookingRepository.findByCustomer_CustomerId(customerId);
    }

    public List<Booking> getBookingsByBranch(Integer branchId) {
        return bookingRepository.findByBranch_BranchId(branchId);
    }

    public List<Booking> getBookingsByStatus(String status) {
        return bookingRepository.findByBookingStatus(status);
    }

    public Booking saveBooking(Booking booking) {
        return bookingRepository.save(booking);
    }

    public void deleteBooking(Integer id) {
        bookingRepository.deleteById(id);
    }
}
