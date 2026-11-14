package com.stayease.hotelbooking.controller;

import com.stayease.hotelbooking.entity.HotelServiceEntity;
import com.stayease.hotelbooking.service.HotelServiceManager;

import jakarta.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/services")
public class HotelServiceController {

    private final HotelServiceManager hotelServiceManager;

    public HotelServiceController(HotelServiceManager hotelServiceManager) {
        this.hotelServiceManager = hotelServiceManager;
    }

    @GetMapping
    public List<HotelServiceEntity> getAllServices() {
        return hotelServiceManager.getAllServices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelServiceEntity> getServiceById(@PathVariable Integer id) {
        return hotelServiceManager.getServiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/branch/{branchId}")
    public List<HotelServiceEntity> getServicesByBranch(@PathVariable Integer branchId) {
        return hotelServiceManager.getServicesByBranch(branchId);
    }

    @GetMapping("/name/{name}")
    public List<HotelServiceEntity> getServicesByName(@PathVariable String name) {
        return hotelServiceManager.getServicesByName(name);
    }

    @PostMapping
    public HotelServiceEntity createService(@Valid @RequestBody HotelServiceEntity service) {
        return hotelServiceManager.saveService(service);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteService(@PathVariable Integer id) {
        hotelServiceManager.deleteService(id);
        return ResponseEntity.noContent().build();
    }
}