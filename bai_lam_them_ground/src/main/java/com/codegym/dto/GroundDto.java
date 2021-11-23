package com.codegym.dto;

import com.codegym.model.Ground;
import com.codegym.model.GroundType;
import com.codegym.model.Status;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GroundDto implements Validator {
    private Long id;

    @NotBlank(message = "Mã mặt bằng không được để trống.")
    @Pattern(regexp = "^[A-Z\\d]{3}[-][A-Z\\d]{2}[-][A-Z\\d]{2}$", message = "Mã mặt bằng phải đúng định dạng: XXX-XX-XX.")
    private String code;

    @NotNull(message = "Diện tích không được để trống.")
    @Min(value = 20, message = "Diện tích phải > 20m2.")
    private Double area;

    @NotNull(message = "Tầng không được để trống.")
    @Max(value = 15, message = "Tầng: 15 tầng tất cả.")
    private Integer floor;

    @NotNull(message = "Giá tiền không được để trống.")
    @Min(value = 1000000, message = "Giá tiền phải lớn hơn 1.000.000 VNĐ.")
    private Double money;

    @NotBlank(message = "Ngày bắt đầu không được để trống.")
    @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$",
            message = "Ngày bắt đầu phải đúng định dạng: dd/MM/yyyy.")
    private String startDate;

    @NotBlank(message = "Ngày kết thúc không được để trống.")
    @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$",
            message = "Ngày kết thúc phải đúng định dạng: dd/MM/yyyy.")
    private String endDate;

    private Status status;

    private GroundType groundType;

    public GroundDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Integer getFloor() {
        return floor;
    }

    public void setFloor(Integer floor) {
        this.floor = floor;
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public GroundType getGroundType() {
        return groundType;
    }

    public void setGroundType(GroundType groundType) {
        this.groundType = groundType;
    }


    List<Ground> grounds;

    public List<Ground> getGrounds() {
        return grounds;
    }

    public void setGrounds(List<Ground> grounds) {
        this.grounds = grounds;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    private boolean checkCode;

    private boolean checkDate;

    public boolean isCheckCode() {
        return checkCode;
    }

    public void setCheckCode(boolean checkCode) {
        this.checkCode = checkCode;
    }

    public boolean isCheckDate() {
        return checkDate;
    }

    public void setCheckDate(boolean checkDate) {
        this.checkDate = checkDate;
    }

    @Override
    public void validate(Object target, Errors errors) {
        GroundDto groundDto = (GroundDto) target;
        for (Ground ground : grounds) {
            if (groundDto.checkCode) {
                if (groundDto.getCode().equals(ground.getCode())) {
                    errors.rejectValue("code", "code.equals", "Mã mặt bằng vừa thêm đã tồn tại.");
                }
            }
        }
        if (groundDto.checkDate) {
            try {
                Date startDate = new SimpleDateFormat("yyyy-MM-dd").parse(groundDto.getStartDate());
                Date endDate = new SimpleDateFormat("yyyy-MM-dd").parse(groundDto.getEndDate());
                long getDiff = endDate.getTime() - startDate.getTime();
                long getDaysDiff = TimeUnit.MILLISECONDS.toDays(getDiff);
                if (getDaysDiff < 180) {
                    errors.rejectValue("endDate", "endDate.getDiff", "Ngày kết thúc phải lớn hơn ngày bắt đầu ít nhất 6 tháng.");
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
    }
}
