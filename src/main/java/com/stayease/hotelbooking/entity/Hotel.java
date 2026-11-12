
package com.stayease.hotelbooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "Hotel")
public class Hotel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "HotelID")
    private Integer hotelId;

    @NotBlank(message = "Hotel name is required")
    @Size(max = 100, message = "Hotel name cannot exceed 100 characters")
    @Column(name = "HotelName")
    private String hotelName;

    @Size(max = 1000, message = "Description cannot exceed 1000 characters")
    @Column(name = "Description")
    private String description;

    public Hotel() {
    }

    public Integer getHotelId() {
        return hotelId;
    }

    public void setHotelId(Integer hotelId) {
        this.hotelId = hotelId;
    }

    public String getHotelName() {
        return hotelName;
    }

    public void setHotelName(String hotelName) {
        this.hotelName = hotelName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
