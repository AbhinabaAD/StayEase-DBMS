
package com.stayease.hotelbooking.entity;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.NotBlank;

import com.stayease.hotelbooking.validation.ValidBookingDates;

@ValidBookingDates
@Entity
@Table(name = "Booking")
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BookingID")
    private Integer bookingId;

    @NotNull(message = "Customer is required")
    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private Customer customer;

    @NotNull(message = "Hotel branch is required")
    @ManyToOne
    @JoinColumn(name = "BranchID", nullable = false)
    private HotelBranch branch;

    @NotNull(message = "Booking date is required")
    @Column(name = "BookingDate")
    private LocalDateTime bookingDate;

    @NotNull(message = "Check-in date is required")
    @Column(name = "CheckInDate")
    private LocalDate checkInDate;

    @NotNull(message = "Check-out date is required")
    @Column(name = "CheckOutDate")
    private LocalDate checkOutDate;

    @NotBlank(message = "Booking status is required")
    @Column(name = "BookingStatus")
    private String bookingStatus;

    public Booking() {
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public HotelBranch getBranch() {
        return branch;
    }

    public void setBranch(HotelBranch branch) {
        this.branch = branch;
    }

    public LocalDateTime getBookingDate() {
        return bookingDate;
    }

    public void setBookingDate(LocalDateTime bookingDate) {
        this.bookingDate = bookingDate;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public String getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }
}
