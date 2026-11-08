
package com.stayease.hotelbooking.repository;

import com.stayease.hotelbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    List<Booking> findByCustomer_CustomerId(Integer customerId);

    List<Booking> findByBranch_BranchId(Integer branchId);

    List<Booking> findByBookingStatus(String bookingStatus);
}
