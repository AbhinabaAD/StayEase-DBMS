
package com.stayease.hotelbooking.service;

import com.stayease.hotelbooking.entity.RoomType;
import com.stayease.hotelbooking.repository.RoomTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomTypeService {

    private final RoomTypeRepository roomTypeRepository;

    public RoomTypeService(RoomTypeRepository roomTypeRepository) {
        this.roomTypeRepository = roomTypeRepository;
    }

    public List<RoomType> getAllRoomTypes() {
        return roomTypeRepository.findAll();
    }

    public Optional<RoomType> getRoomTypeById(Integer id) {
        return roomTypeRepository.findById(id);
    }

    public Optional<RoomType> getRoomTypeByName(String name) {
        return roomTypeRepository.findByTypeName(name);
    }

    public RoomType saveRoomType(RoomType roomType) {
        return roomTypeRepository.save(roomType);
    }

    public void deleteRoomType(Integer id) {
        roomTypeRepository.deleteById(id);
    }
}
