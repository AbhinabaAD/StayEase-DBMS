package com.stayease.hotelbooking.repository;

import com.stayease.hotelbooking.entity.BookingService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingServiceRepository
        extends JpaRepository<BookingService, Integer> {

    List<BookingService> findByBooking_BookingId(Integer bookingId);

    List<BookingService> findByService_ServiceId(Integer serviceId);
}