
package com.stayease.hotelbooking.repository;

import com.stayease.hotelbooking.entity.RoomType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomTypeRepository extends JpaRepository<RoomType, Integer> {

    Optional<RoomType> findByTypeName(String typeName);
}
