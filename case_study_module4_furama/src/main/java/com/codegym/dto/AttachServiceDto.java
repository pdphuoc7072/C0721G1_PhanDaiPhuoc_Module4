package com.codegym.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class AttachServiceDto {
    private Long attachServiceId;

    private String attachServiceName;

    @NotNull(message = "Giá tiền không được để trống.")
    @Min(value = 1, message = "Giá tiền phải là số dương.")
    private Double attachServiceCost;

    @NotNull(message = "Đơn vị không được để trống.")
    @Min(value = 1, message = "Đơn vị phải là số dương.")
    private Integer attachServiceUnit;

    private String attachServiceStatus;

    public AttachServiceDto() {
    }

    public Long getAttachServiceId() {
        return attachServiceId;
    }

    public void setAttachServiceId(Long attachServiceId) {
        this.attachServiceId = attachServiceId;
    }

    public String getAttachServiceName() {
        return attachServiceName;
    }

    public void setAttachServiceName(String attachServiceName) {
        this.attachServiceName = attachServiceName;
    }

    public Double getAttachServiceCost() {
        return attachServiceCost;
    }

    public void setAttachServiceCost(Double attachServiceCost) {
        this.attachServiceCost = attachServiceCost;
    }

    public Integer getAttachServiceUnit() {
        return attachServiceUnit;
    }

    public void setAttachServiceUnit(Integer attachServiceUnit) {
        this.attachServiceUnit = attachServiceUnit;
    }

    public String getAttachServiceStatus() {
        return attachServiceStatus;
    }

    public void setAttachServiceStatus(String attachServiceStatus) {
        this.attachServiceStatus = attachServiceStatus;
    }
}
