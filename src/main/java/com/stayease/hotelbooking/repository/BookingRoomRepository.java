
package com.stayease.hotelbooking.repository;

import com.stayease.hotelbooking.entity.BookingRoom;
import com.stayease.hotelbooking.entity.BookingRoomId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookingRoomRepository
        extends JpaRepository<BookingRoom, BookingRoomId> {

    List<BookingRoom> findByBooking_BookingId(Integer bookingId);

    List<BookingRoom> findByRoom_RoomId(Integer roomId);
}
