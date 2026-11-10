package com.stayease.hotelbooking.repository;

import com.stayease.hotelbooking.entity.HotelServiceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelServiceRepository
        extends JpaRepository<HotelServiceEntity, Integer> {

    List<HotelServiceEntity> findByBranch_BranchId(Integer branchId);

    List<HotelServiceEntity> findByServiceNameIgnoreCase(String serviceName);
}