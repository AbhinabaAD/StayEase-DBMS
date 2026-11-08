
package com.stayease.hotelbooking.repository;

import com.stayease.hotelbooking.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Integer> {

    List<Room> findByBranch_BranchId(Integer branchId);

    List<Room> findByRoomType_RoomTypeId(Integer roomTypeId);

    List<Room> findByRoomStatus(String roomStatus);
}
