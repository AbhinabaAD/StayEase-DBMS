package com.stayease.hotelbooking.entity;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Service")
public class HotelServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ServiceID")
    private Integer serviceId;

    @NotNull(message = "Hotel branch is required")
    @ManyToOne
    @JoinColumn(name = "BranchID", nullable = false)
    private HotelBranch branch;

    @NotBlank(message = "Service name is required")
    @Size(max = 100, message = "Service name cannot exceed 100 characters")
    @Column(name = "ServiceName")
    private String serviceName;

    @Column(name = "Description")
    private String description;

    @PositiveOrZero(message = "Service price cannot be negative")
    @NotNull(message = "Service price is required")
    @Column(name = "ServicePrice")
    private BigDecimal servicePrice;

    public HotelServiceEntity() {
    }

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
    }

    public HotelBranch getBranch() {
        return branch;
    }

    public void setBranch(HotelBranch branch) {
        this.branch = branch;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }
}