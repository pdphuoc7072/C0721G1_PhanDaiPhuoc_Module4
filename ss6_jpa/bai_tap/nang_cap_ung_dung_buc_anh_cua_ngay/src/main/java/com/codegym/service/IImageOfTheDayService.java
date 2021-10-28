package com.codegym.service;

import com.codegym.model.ImageOfTheDay;

import java.util.List;

public interface IImageOfTheDayService {
    List<ImageOfTheDay> findAll();
    void saveOrUpdate(ImageOfTheDay imageOfTheDay);
    ImageOfTheDay like(Long id);
    ImageOfTheDay findById(Long id);
}