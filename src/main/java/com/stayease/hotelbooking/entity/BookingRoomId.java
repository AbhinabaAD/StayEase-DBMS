
package com.stayease.hotelbooking.entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class BookingRoomId implements Serializable {

    private Integer bookingId;
    private Integer roomId;

    public BookingRoomId() {
    }

    public BookingRoomId(Integer bookingId, Integer roomId) {
        this.bookingId = bookingId;
        this.roomId = roomId;
    }

    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (!(o instanceof BookingRoomId))
            return false;
        BookingRoomId that = (BookingRoomId) o;
        return Objects.equals(bookingId, that.bookingId)
                && Objects.equals(roomId, that.roomId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingId, roomId);
    }
}
