
package com.stayease.hotelbooking.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "HotelBranch")
public class HotelBranch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BranchID")
    private Integer branchId;

    @ManyToOne
    @JoinColumn(name = "HotelID", nullable = false)
    private Hotel hotel;

    @NotBlank(message = "Branch name is required")
    @Size(max = 100, message = "Branch name cannot exceed 100 characters")
    @Column(name = "BranchName")
    private String branchName;

    @Column(name = "Address")
    private String address;

    @Column(name = "City")
    private String city;

    @NotBlank(message = "State is required")
    @Size(max = 100, message = "State cannot exceed 100 characters")
    @Column(name = "State")
    private String state;

    @NotBlank(message = "Pincode is required")
    @Size(max = 10, message = "Pincode cannot exceed 10 characters")
    @Column(name = "Pincode")
    private String pincode;

    @NotBlank(message = "Country is required")
    @Size(max = 100, message = "Country cannot exceed 100 characters")
    @Column(name = "Country")
    private String country;

    @Column(name = "Phone")
    private String phone;

    public HotelBranch() {
    }

    public Integer getBranchId() {
        return branchId;
    }

    public void setBranchId(Integer branchId) {
        this.branchId = branchId;
    }

    public Hotel getHotel() {
        return hotel;
    }

    public void setHotel(Hotel hotel) {
        this.hotel = hotel;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
