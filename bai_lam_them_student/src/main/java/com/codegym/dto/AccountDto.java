package com.codegym.dto;

import com.codegym.model.Account;
import com.codegym.model.Student;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class AccountDto implements Validator {
    private Long id;

    @NotBlank(message = "Username không được để trống.")
    @Pattern(regexp = "^[a-zA-Z0-9]([._-](?![._-])|[a-zA-Z0-9]){3,18}[a-zA-Z0-9]$",
            message = "Username phải đúng định dạng, từ 5-20 ký tự.")
    private String username;

    @NotBlank(message = "Password không được để trống.")
    @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>_]).{8,20}$",
            message = "Password phải có ít nhất 1 ký tự in hoa, ký tự đặc biệt, ký tự số, từ 8-20 ký tự .")
    private String password;

    private Student student;

    private boolean flag;

    public AccountDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    List<Account> accounts = new ArrayList<>();

    private boolean checkUsername;

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    public boolean isCheckUsername() {
        return checkUsername;
    }

    public void setCheckUsername(boolean checkUsername) {
        this.checkUsername = checkUsername;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        AccountDto accountDto = (AccountDto) target;
        for (Account account : accounts) {
            if (accountDto.checkUsername) {
                if (accountDto.getUsername().equals(account.getUsername())) {
                    errors.rejectValue("username", "username.equals", "Username này đã tồn tại.");
                }
            }
        }
    }
}
