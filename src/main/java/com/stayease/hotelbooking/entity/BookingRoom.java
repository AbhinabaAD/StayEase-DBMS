
package com.stayease.hotelbooking.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Entity
@Table(name = "BookingRoom")
public class BookingRoom {

    @EmbeddedId
    private BookingRoomId id;

    @NotNull(message = "Booking is required")
    @ManyToOne
    @MapsId("bookingId")
    @JoinColumn(name = "BookingID")
    private Booking booking;

    @NotNull(message = "Room is required")
    @ManyToOne
    @MapsId("roomId")
    @JoinColumn(name = "RoomID")
    private Room room;

    @NotNull(message = "Agreed rate is required")
    @Positive(message = "Agreed rate must be greater than zero")
    @Column(name = "AgreedRatePerNight")
    private BigDecimal agreedRatePerNight;

    public BookingRoom() {
    }

    public BookingRoomId getId() {
        return id;
    }

    public void setId(BookingRoomId id) {
        this.id = id;
    }

    public Booking getBooking() {
        return booking;
    }

    public void setBooking(Booking booking) {
        this.booking = booking;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public BigDecimal getAgreedRatePerNight() {
        return agreedRatePerNight;
    }

    public void setAgreedRatePerNight(BigDecimal agreedRatePerNight) {
        this.agreedRatePerNight = agreedRatePerNight;
    }
}
