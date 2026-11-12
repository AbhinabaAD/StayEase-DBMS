
package com.stayease.hotelbooking.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import jakarta.persistence.*;

@Entity
@Table(name = "Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoomID")
    private Integer roomId;

    @ManyToOne
    @JoinColumn(name = "BranchID", nullable = false)
    private HotelBranch branch;

    @NotBlank(message = "Room number is required")
    @Size(max = 20, message = "Room number cannot exceed 20 characters")
    @Column(name = "RoomNumber")
    private String roomNumber;

    @ManyToOne
    @JoinColumn(name = "RoomTypeID", nullable = false)
    private RoomType roomType;

    @PositiveOrZero(message = "Floor cannot be negative")
    @Column(name = "Floor")
    private Integer floor;

    @NotBlank(message = "Room status is required")
    @Column(name = "RoomStatus")
    private String roomStatus;

    public Room() {
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

    public HotelBranch getBranch() {
        return branch;
    }

    public void setBranch(HotelBranch branch) {
        this.branch = branch;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public RoomType getRoomType() {
        return roomType;
    }

    public void setRoomType(RoomType roomType) {
        this.roomType = roomType;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public String getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) {
        this.roomStatus = roomStatus;
    }
}
