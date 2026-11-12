
package com.stayease.hotelbooking.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import jakarta.persistence.*;

@Entity
@Table(name = "RoomType")
public class RoomType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoomTypeID")
    private Integer roomTypeId;

    @NotBlank(message = "Room type name is required")
    @Size(max = 50, message = "Room type name cannot exceed 50 characters")
    @Column(name = "TypeName")
    private String typeName;

    @Positive(message = "Capacity must be greater than zero")
    @Column(name = "Capacity")
    private Integer capacity;

    @Column(name = "Description")
    private String description;

    public RoomType() {
    }

    public Integer getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Integer roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
