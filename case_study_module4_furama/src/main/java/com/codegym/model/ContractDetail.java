package com.codegym.model;

import javax.persistence.*;

@Entity
public class ContractDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long contractDetailId;

    private Integer quantity;

    @ManyToOne(targetEntity = Contract.class)
    @JoinColumn(name = "contract_id", referencedColumnName = "contractId")
    private Contract contract;

    @ManyToOne(targetEntity = AttachService.class)
    @JoinColumn(name = "attach_service_id", referencedColumnName = "attachServiceId")
    private AttachService attachService;

    public ContractDetail() {
    }

    public ContractDetail(Integer quantity) {
        this.quantity = quantity;
    }

    public ContractDetail(Long contractDetailId, Integer quantity) {
        this.contractDetailId = contractDetailId;
        this.quantity = quantity;
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
