
package com.stayease.hotelbooking.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "BookingRoom")
public class BookingRoom {

    @EmbeddedId
    private BookingRoomId id;

    @ManyToOne
    @MapsId("bookingId")
    @JoinColumn(name = "BookingID")
    private Booking booking;

    @ManyToOne
    @MapsId("roomId")
    @JoinColumn(name = "RoomID")
    private Room room;

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
