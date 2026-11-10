package com.stayease.hotelbooking.service;

import com.stayease.hotelbooking.entity.HotelServiceEntity;
import com.stayease.hotelbooking.repository.HotelServiceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HotelServiceManager {

    private final HotelServiceRepository hotelServiceRepository;

    public HotelServiceManager(HotelServiceRepository hotelServiceRepository) {
        this.hotelServiceRepository = hotelServiceRepository;
    }

    public List<HotelServiceEntity> getAllServices() {
        return hotelServiceRepository.findAll();
    }

    public Optional<HotelServiceEntity> getServiceById(Integer id) {
        return hotelServiceRepository.findById(id);
    }

    public List<HotelServiceEntity> getServicesByBranch(Integer branchId) {
        return hotelServiceRepository.findByBranch_BranchId(branchId);
    }

    public List<HotelServiceEntity> getServicesByName(String serviceName) {
        return hotelServiceRepository.findByServiceNameIgnoreCase(serviceName);
    }

    public HotelServiceEntity saveService(HotelServiceEntity service) {
        return hotelServiceRepository.save(service);
    }

    public void deleteService(Integer id) {
        hotelServiceRepository.deleteById(id);
    }
}