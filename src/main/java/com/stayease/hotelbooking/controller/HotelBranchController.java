
package com.stayease.hotelbooking.controller;

import com.stayease.hotelbooking.entity.HotelBranch;
import com.stayease.hotelbooking.service.HotelBranchService;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/branches")
@CrossOrigin(origins = "*")
public class HotelBranchController {

    private final HotelBranchService branchService;

    public HotelBranchController(HotelBranchService branchService) {
        this.branchService = branchService;
    }

    @GetMapping
    public List<HotelBranch> getAllBranches() {
        return branchService.getAllBranches();
    }

    @GetMapping("/{id}")
    public ResponseEntity<HotelBranch> getBranchById(@PathVariable Integer id) {
        return branchService.getBranchById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/hotel/{hotelId}")
    public List<HotelBranch> getBranchesByHotel(@PathVariable Integer hotelId) {
        return branchService.getBranchesByHotel(hotelId);
    }

    @GetMapping("/city/{city}")
    public List<HotelBranch> getBranchesByCity(@PathVariable String city) {
        return branchService.getBranchesByCity(city);
    }

    @PostMapping
    public HotelBranch createBranch(@Valid @RequestBody HotelBranch branch) {
        return branchService.saveBranch(branch);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable Integer id) {
        branchService.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
}
