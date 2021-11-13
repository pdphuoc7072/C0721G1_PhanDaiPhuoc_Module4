package com.codegym.controller;

import com.codegym.dto.ServiceDetail;
import com.codegym.service.IServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/service-detail")
public class ServiceDetailController {
    @Autowired
    private IServiceService serviceService;

    @GetMapping("")
    private ModelAndView list () {
        List<ServiceDetail> serviceDetailList = serviceService.listServiceDetail();
        ModelAndView modelAndView = new ModelAndView("service_detail/list");
        modelAndView.addObject("serviceDetailList", serviceDetailList);
        return modelAndView;
    }

    @GetMapping("/detail/{id}")
    public ResponseEntity<?> listById (@PathVariable Integer id) {
        List<ServiceDetail> serviceDetail = serviceService.listServiceDetailById(id);
        return new ResponseEntity<>(serviceDetail, HttpStatus.OK);
    }
}
