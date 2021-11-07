package com.codegym.dto;

import com.codegym.model.AttachService;
import com.codegym.model.Contract;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class ContractDetailDto {
    private Long contractDetailId;

    @NotNull(message = "Số lượng không được để trống.")
    @Min(value = 1, message = "Số lượng phải là số dương.")
    private Integer quantity;

    private Contract contract;

    private AttachService attachService;

    public ContractDetailDto() {
    }

    public Long getContractDetailId() {
        return contractDetailId;
    }

    public void setContractDetailId(Long contractDetailId) {
        this.contractDetailId = contractDetailId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public AttachService getAttachService() {
        return attachService;
    }

    public void setAttachService(AttachService attachService) {
        this.attachService = attachService;
    }
}
