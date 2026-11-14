
package com.stayease.hotelbooking.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PaymentID")
    private Integer paymentId;

    @NotNull(message = "Booking is required")
    @ManyToOne
    @JoinColumn(name = "BookingID", nullable = false)
    private Booking booking;

    @NotNull(message = "Payment date is required")
    @Column(name = "PaymentDate")
    private LocalDateTime paymentDate;

    @NotNull(message = "Payment amount is required")
    @Positive(message = "Payment amount must be greater than zero")
    @Column(name = "Amount")
    private BigDecimal amount;

    @NotBlank(message = "Payment method is required")
    @Size(max = 20, message = "Payment method cannot exceed 20 characters")
    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @NotBlank(message = "Payment status is required")
    @Size(max = 20, message = "Payment status cannot exceed 20 characters")
    @Column(name = "PaymentStatus")
    private String paymentStatus;

    @Column(name = "TransactionReference")
    private String transactionReference;

    public Payment() {
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public LocalDateTime getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(LocalDateTime paymentDate) {
        this.paymentDate = paymentDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public String getTransactionReference() {
        return transactionReference;
    }

    public void setTransactionReference(String transactionReference) {
        this.transactionReference = transactionReference;
    }
}
