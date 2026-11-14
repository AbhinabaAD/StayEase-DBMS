package com.stayease.hotelbooking.entity;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.PositiveOrZero;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "BookingService")
public class BookingService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookingServiceID")
    private Integer bookingServiceId;

    @NotNull(message = "Booking is required")
    @ManyToOne
    @JoinColumn(name = "BookingID", nullable = false)
    private Booking booking;

    @NotNull(message = "Hotel service is required")
    @ManyToOne
    @JoinColumn(name = "ServiceID", nullable = false)
    private HotelServiceEntity service;

    @NotNull(message = "Service date is required")
    @Column(name = "ServiceDate")
    private LocalDate serviceDate;

    @NotNull(message = "Quantity is required")
    @Positive(message = "Quantity must be greater than zero")
    @Column(name = "Quantity")
    private Integer quantity;

    @NotNull(message = "Unit price is required")
    @PositiveOrZero(message = "Unit price cannot be negative")
    @Column(name = "UnitPrice")
    private BigDecimal unitPrice;

    public BookingService() {
    }

    public Integer getBookingServiceId() {
        return bookingServiceId;
    }

    public void setBookingServiceId(Integer bookingServiceId) {
        this.bookingServiceId = bookingServiceId;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public HotelServiceEntity getService() {
        return service;
    }

    public void setService(HotelServiceEntity service) {
        this.service = service;
    }

    public LocalDate getServiceDate() {
        return serviceDate;
    }

    public void setServiceDate(LocalDate serviceDate) {
        this.serviceDate = serviceDate;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}