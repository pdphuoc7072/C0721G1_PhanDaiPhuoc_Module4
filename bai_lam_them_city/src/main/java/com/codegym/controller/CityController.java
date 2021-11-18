package com.codegym.controller;

import com.codegym.dto.CityDto;
import com.codegym.model.City;
import com.codegym.model.Country;
import com.codegym.service.ICityService;
import com.codegym.service.ICountryService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/city")
public class CityController {
    @Autowired
    private ICityService cityService;

    @Autowired
    private ICountryService countryService;

    @ModelAttribute("countries")
    public List<Country> countries () {
        return countryService.findAll();
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("city/create");
        modelAndView.addObject("cityDto", new CityDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("cityDto") CityDto cityDto, BindingResult bindingResult) {
        boolean checkName = true;
        cityDto.setCities(cityService.findAll());
        cityDto.setCheckName(checkName);
        cityDto.validate(cityDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "city/create";
        } else {
            City city = new City();
            BeanUtils.copyProperties(cityDto, city);
            cityService.save(city);
            return "redirect:/city";
        }
    }

    @GetMapping("")
    public ModelAndView list(@RequestParam(value = "code", defaultValue = "", required = false) String code,
                             @RequestParam(value = "name", defaultValue = "", required = false) String name,
                             @RequestParam(value = "countryId", defaultValue = "", required = false) String countryId,
                             @PageableDefault(size = 3) Pageable pageable) {
        Page<City> cities = cityService.findAll(pageable, code, name, countryId);
        ModelAndView modelAndView = new ModelAndView("/city/list");
        modelAndView.addObject("cities", cities);
        modelAndView.addObject("code", code);
        modelAndView.addObject("name", name);
        modelAndView.addObject("countryId", countryId);
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        CityDto cityDto = new CityDto();
        BeanUtils.copyProperties(city.get(), cityDto);
        ModelAndView modelAndView;
        if (cityDto != null) {
            modelAndView = new ModelAndView("/city/edit");
            modelAndView.addObject("cityDto", cityDto);
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("cityDto") CityDto cityDto, BindingResult bindingResult) {
        List<City> cities = cityService.findAll();
        Optional<City> cityOptional = cityService.findById(cityDto.getId());
        String oldName = cityOptional.get().getName();
        boolean checkName = false;

        if (!oldName.equals(cityDto.getName())) {
            checkName = true;
            cityDto.setCities(cities);
            cityDto.setCheckName(checkName);
            cityDto.validate(cityDto, bindingResult);
            checkName = false;
        }

        if (bindingResult.hasFieldErrors()) {
            return "city/edit";
        } else {
            City city = new City();
            BeanUtils.copyProperties(cityDto, city);
            cityService.save(city);
            return "redirect:/city";
        }
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long idCity) {
        cityService.remove(idCity);
        return "redirect:/city";
    }

    @PostMapping("/deleteMultiple")
    public String deleteMultiple(@RequestParam String idCityMultiple) {
        String[] idCityMultipleArray = idCityMultiple.split(",");
        for (int i = 0; i < idCityMultipleArray.length; i++) {
            cityService.remove(Long.valueOf(idCityMultipleArray[i]));
        }
        return "redirect:/city";
    }

    @GetMapping("/view/{id}")
    public ResponseEntity<?> view(@PathVariable Long id) {
        Optional<City> city = cityService.findById(id);
        return new ResponseEntity<>(city.get(), HttpStatus.OK);
    }
}
