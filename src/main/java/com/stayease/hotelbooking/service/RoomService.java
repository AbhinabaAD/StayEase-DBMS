
package com.stayease.hotelbooking.service;

import com.stayease.hotelbooking.entity.Room;
import com.stayease.hotelbooking.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> getAllRooms() {
        return roomRepository.findAll();
    }

    public Optional<Room> getRoomById(Integer id) {
        return roomRepository.findById(id);
    }

    public List<Room> getRoomsByBranch(Integer branchId) {
        return roomRepository.findByBranch_BranchId(branchId);
    }

    public List<Room> getRoomsByType(Integer roomTypeId) {
        return roomRepository.findByRoomType_RoomTypeId(roomTypeId);
    }

    public List<Room> getRoomsByStatus(String status) {
        return roomRepository.findByRoomStatus(status);
    }

    public Room saveRoom(Room room) {
        return roomRepository.save(room);
    }

    public void deleteRoom(Integer id) {
        roomRepository.deleteById(id);
    }
}
