package com.codegym.dto;

import com.codegym.model.*;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDto implements Validator {

    private Long employeeId;

    @NotBlank(message = "Họ tên không được để trống.")
    @Pattern(regexp = "^([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10}|[\\p{Lu}]\\d*[\\p{Lu}]*|\\d*)){0,5}$",
            message = "Họ tên phải đúng định dạng.")
    private String employeeName;

    @NotBlank(message = "Ngày sinh không được để trống.")
    @Pattern(regexp = "^(?:19\\d{2}|20\\d{2})[-/.](?:0[1-9]|1[012])[-/.](?:0[1-9]|[12][0-9]|3[01])$",
            message = "Ngày sinh phải đúng định dạng: dd/MM/yyyy.")
    private String employeeBirthday;

    @NotBlank(message = "Số CMND không được để trống.")
    @Pattern(regexp = "^([0-9]{9})|([0-9]{12})$",
            message = "Số CMND phải đúng định dạng: XXXXXXXXX hoặc XXXXXXXXXXXX.")
    private String employeeIdCard;

    @NotNull(message = "Lương không được để trống.")
    @Min(value = 1, message = "Lương phải là số dương.")
    private Double employeeSalary;

    @NotBlank(message = "Số điện thoại không được để trống.")
    @Pattern(regexp = "^(0|(\\(84\\)\\+))+([9][0-1][0-9]{7})$",
            message = "Số điện thoại phải đúng định dạng: 090xxxxxxx hoặc 091xxxxxxx hoặc (84)+90xxxxxxx hoặc (84)+91xxxxxxx")
    private String employeePhone;

    @NotBlank(message = "Email không được để trống.")
    @Pattern(regexp = "^(?:^|\\s)[\\w!#$%&'*+/=?^`{|}~-](\\.?[\\w!#$%&'*+/=?^`{|}~-]+)*@\\w+[.-]?\\w*\\.[a-zA-Z]{2,3}\\b$",
            message = "Email phải đúng định dạng.")
    private String employeeEmail;

    private String employeeAddress;

    private Position position;

    private EducationDegree educationDegree;

    private Division division;

    private User user;

    public EmployeeDto() {
    }

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeBirthday() {
        return employeeBirthday;
    }

    public void setEmployeeBirthday(String employeeBirthday) {
        this.employeeBirthday = employeeBirthday;
    }

    public String getEmployeeIdCard() {
        return employeeIdCard;
    }

    public void setEmployeeIdCard(String employeeIdCard) {
        this.employeeIdCard = employeeIdCard;
    }

    public Double getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(Double employeeSalary) {
        this.employeeSalary = employeeSalary;
    }

    public String getEmployeePhone() {
        return employeePhone;
    }

    public void setEmployeePhone(String employeePhone) {
        this.employeePhone = employeePhone;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationDegree getEducationDegree() {
        return educationDegree;
    }

    public void setEducationDegree(EducationDegree educationDegree) {
        this.educationDegree = educationDegree;
    }

    public Division getDivision() {
        return division;
    }

    public void setDivision(Division division) {
        this.division = division;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    List<Employee> employees = new ArrayList<>();

    private boolean checkIdCard;

    private boolean checkPhone;

    private boolean checkEmail;

    public boolean isCheckEmail() {
        return checkEmail;
    }

    public void setCheckEmail(boolean checkEmail) {
        this.checkEmail = checkEmail;
    }

    public boolean isCheckPhone() {
        return checkPhone;
    }

    public void setCheckPhone(boolean checkPhone) {
        this.checkPhone = checkPhone;
    }

    public boolean isCheckIdCard() {
        return checkIdCard;
    }

    public void setCheckIdCard(boolean checkIdCard) {
        this.checkIdCard = checkIdCard;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmployeeDto employeeDto = (EmployeeDto) target;
        for (Employee employee : employees) {
            if (employeeDto.checkIdCard) {
                if (employeeDto.getEmployeeIdCard().equals(employee.getEmployeeIdCard())) {
                    errors.rejectValue("employeeIdCard", "employeeIdCard.equals", "Id card này đã tồn tại.");
                }
            }
            if (employeeDto.checkPhone) {
                if (employeeDto.getEmployeePhone().equals(employee.getEmployeePhone())){
                    errors.rejectValue("employeePhone", "employeePhone.equals", "Số ĐT này đã tồn tại.");
                }
            }
            if (employeeDto.checkEmail) {
                if (employeeDto.getEmployeeEmail().equals(employee.getEmployeeEmail())){
                    errors.rejectValue("employeeEmail", "employeeEmail.equals", "Email này đã tồn tại.");
                }
            }
        }
    }
}
