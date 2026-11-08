
package com.stayease.hotelbooking.service;

import com.stayease.hotelbooking.entity.HotelBranch;
import com.stayease.hotelbooking.repository.HotelBranchRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelBranchService {

    private final HotelBranchRepository branchRepository;

    public HotelBranchService(HotelBranchRepository branchRepository) {
        this.branchRepository = branchRepository;
    }

    public List<HotelBranch> getAllBranches() {
        return branchRepository.findAll();
    }

    public Optional<HotelBranch> getBranchById(Integer id) {
        return branchRepository.findById(id);
    }

    public List<HotelBranch> getBranchesByHotel(Integer hotelId) {
        return branchRepository.findByHotel_HotelId(hotelId);
    }

    public List<HotelBranch> getBranchesByCity(String city) {
        return branchRepository.findByCityIgnoreCase(city);
    }

    public HotelBranch saveBranch(HotelBranch branch) {
        return branchRepository.save(branch);
    }

    public void deleteBranch(Integer id) {
        branchRepository.deleteById(id);
    }
}
