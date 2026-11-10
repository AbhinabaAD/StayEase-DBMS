package com.stayease.hotelbooking.entity;

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

    @ManyToOne
    @JoinColumn(name = "BookingID", nullable = false)
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "ServiceID", nullable = false)
    private HotelServiceEntity service;

    @Column(name = "ServiceDate")
    private LocalDate serviceDate;

    @Column(name = "Quantity")
    private Integer quantity;

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