package com.codegym.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ServiceType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long serviceTypeId;

    private String serviceTypeName;

    @OneToMany(mappedBy = "serviceType")
    private Set<Service> services;

    public ServiceType() {
    }

    public ServiceType(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public ServiceType(Long serviceTypeId, String serviceTypeName) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
    }

    public Long getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Long serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }
}
