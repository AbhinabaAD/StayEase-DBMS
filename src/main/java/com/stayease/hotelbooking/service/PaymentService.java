
package com.stayease.hotelbooking.service;

import com.stayease.hotelbooking.entity.Payment;
import com.stayease.hotelbooking.repository.PaymentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    public Optional<Payment> getPaymentById(Integer id) {
        return paymentRepository.findById(id);
    }

    public List<Payment> getPaymentsByBooking(Integer bookingId) {
        return paymentRepository.findByBooking_BookingId(bookingId);
    }

    public List<Payment> getPaymentsByStatus(String status) {
        return paymentRepository.findByPaymentStatus(status);
    }

    public List<Payment> getPaymentsByMethod(String method) {
        return paymentRepository.findByPaymentMethod(method);
    }

    public Payment savePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    public void deletePayment(Integer id) {
        paymentRepository.deleteById(id);
    }
}
