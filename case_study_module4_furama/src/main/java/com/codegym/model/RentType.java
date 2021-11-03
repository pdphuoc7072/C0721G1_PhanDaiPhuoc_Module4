package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rentTypeId;

    private String rentTypeName;

    private Double rentTypeCost;

    @OneToMany(mappedBy = "rentType")
    private Set<Service> services;

    public RentType() {
    }

    public RentType(String rentTypeName, Double rentTypeCost) {
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public RentType(Long rentTypeId, String rentTypeName, Double rentTypeCost) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.rentTypeCost = rentTypeCost;
    }

    public Long getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(Long rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public Double getRentTypeCost() {
        return rentTypeCost;
    }

    public void setRentTypeCost(Double rentTypeCost) {
        this.rentTypeCost = rentTypeCost;
    }
}
