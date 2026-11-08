
package com.stayease.hotelbooking.repository;

import com.stayease.hotelbooking.entity.HotelBranch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HotelBranchRepository extends JpaRepository<HotelBranch, Integer> {

    List<HotelBranch> findByHotel_HotelId(Integer hotelId);

    List<HotelBranch> findByCityIgnoreCase(String city);
}
