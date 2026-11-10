package com.stayease.hotelbooking.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "Service")
public class HotelServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ServiceID")
    private Integer serviceId;

    @ManyToOne
    @JoinColumn(name = "BranchID", nullable = false)
    private HotelBranch branch;

    @Column(name = "ServiceName")
    private String serviceName;

    @Column(name = "Description")
    private String description;

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