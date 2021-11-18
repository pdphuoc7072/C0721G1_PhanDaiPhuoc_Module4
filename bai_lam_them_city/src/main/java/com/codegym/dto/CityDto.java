package com.codegym.dto;

import com.codegym.model.City;
import com.codegym.model.Country;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

public class CityDto implements Validator {
    private Long id;

    @NotBlank(message = "Mã city không được để trống.")
    @Pattern(regexp = "^(CT-)(\\d{4})$", message = "Mã city phải đúng định dạng: CT-XXXX.")
    private String code;

    @NotBlank(message = "Tên city không được để trống.")
    private String name;

    @NotNull(message = "Diện tích không được để trống.")
    @Min(value = 1, message = "Diện tích phải là số dương.")
    private Double area;

    @NotNull(message = "Dân số không được để trống.")
    @Min(value = 1, message = "Dân số phải là số dương.")
    private Long population;

    @NotNull(message = "Gdp không được để trống.")
    private Double gdp;

    private String description;

    private Country country;

    public CityDto() {
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Long getPopulation() {
        return population;
    }

    public void setPopulation(Long population) {
        this.population = population;
    }

    public Double getGdp() {
        return gdp;
    }

    public void setGdp(Double gdp) {
        this.gdp = gdp;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    List<City> cities = new ArrayList<>();

    private boolean checkName;

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public boolean isCheckName() {
        return checkName;
    }

    public void setCheckName(boolean checkName) {
        this.checkName = checkName;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CityDto cityDto = (CityDto) target;
        for (City city : cities) {
            if (cityDto.checkName) {
                if (cityDto.getName().equals(city.getName())) {
                    errors.rejectValue("name", "name.equals", "Tên city đã tồn tại.");
                }
            }
        }
    }
}
