package com.codegym.dto;

import com.codegym.model.Customer;
import com.codegym.model.Employee;
import com.codegym.model.Service;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

public class ContractDto {
    private Long contractId;

    @NotBlank(message = "Ngày bắt đầu hợp đồng không được để trống.")
    @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$",
            message = "Ngày bắt đầu hợp đồng phải đúng định dạng: dd/MM/yyyy.")
    private String contractStartDate;

    @NotBlank(message = "Ngày kết thúc hợp đồng không được để trống.")
    @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$",
            message = "Ngày kết thúc hợp đồng phải đúng định dạng: dd/MM/yyyy.")
    private String contractEndDate;

    @NotNull(message = "Tiền đặt cọc không được để trống.")
    @Min(value = 1, message = "Tiền đặt cọc phải là số dương.")
    private Double contractDeposit;

    @NotNull(message = "Tổng tiền không được để trống.")
    @Min(value = 1, message = "Tổng tiền phải là số dương.")
    private Double contractTotalMoney;

    private Employee employee;

    private Customer customer;

    private Service service;

    public ContractDto() {
    }

    public Long getContractId() {
        return contractId;
    }

    public void setContractId(Long contractId) {
        this.contractId = contractId;
    }

    public String getContractStartDate() {
        return contractStartDate;
    }

    public void setContractStartDate(String contractStartDate) {
        this.contractStartDate = contractStartDate;
    }

    public String getContractEndDate() {
        return contractEndDate;
    }

    public void setContractEndDate(String contractEndDate) {
        this.contractEndDate = contractEndDate;
    }

    public Double getContractDeposit() {
        return contractDeposit;
    }

    public void setContractDeposit(Double contractDeposit) {
        this.contractDeposit = contractDeposit;
    }

    public Double getContractTotalMoney() {
        return contractTotalMoney;
    }

    public void setContractTotalMoney(Double contractTotalMoney) {
        this.contractTotalMoney = contractTotalMoney;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
