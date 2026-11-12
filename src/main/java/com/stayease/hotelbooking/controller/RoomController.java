
package com.stayease.hotelbooking.controller;

import com.stayease.hotelbooking.entity.Room;
import com.stayease.hotelbooking.service.RoomService;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/rooms")
@CrossOrigin(origins = "*")
public class RoomController {

    private final RoomService roomService;

    public RoomController(RoomService roomService) {
        this.roomService = roomService;
    }

    @GetMapping
    public List<Room> getAllRooms() {
        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Room> getRoomById(@PathVariable Integer id) {
        return roomService.getRoomById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/branch/{branchId}")
    public List<Room> getRoomsByBranch(@PathVariable Integer branchId) {
        return roomService.getRoomsByBranch(branchId);
    }

    @GetMapping("/type/{roomTypeId}")
    public List<Room> getRoomsByType(@PathVariable Integer roomTypeId) {
        return roomService.getRoomsByType(roomTypeId);
    }

    @GetMapping("/status/{status}")
    public List<Room> getRoomsByStatus(@PathVariable String status) {
        return roomService.getRoomsByStatus(status);
    }

    @PostMapping
    public Room createRoom(@Valid @RequestBody Room room) {
        return roomService.saveRoom(room);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRoom(@PathVariable Integer id) {
        roomService.deleteRoom(id);
        return ResponseEntity.noContent().build();
    }
}
