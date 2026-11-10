
package com.stayease.hotelbooking.repository;

import com.stayease.hotelbooking.entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PaymentRepository extends JpaRepository<Payment, Integer> {

    List<Payment> findByBooking_BookingId(Integer bookingId);

    List<Payment> findByPaymentStatus(String paymentStatus);

    List<Payment> findByPaymentMethod(String paymentMethod);
}
