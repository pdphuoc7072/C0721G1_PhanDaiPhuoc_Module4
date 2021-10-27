package com.codegym.service;

import com.codegym.model.ImageOfTheDay;

import java.util.List;

public interface ImageOfTheDayService {
    List<ImageOfTheDay> findAll();
    void save (ImageOfTheDay imageOfTheDay);
    ImageOfTheDay update (ImageOfTheDay imageOfTheDay);
    ImageOfTheDay like (Long id);
    ImageOfTheDay findById (Long id);
}
