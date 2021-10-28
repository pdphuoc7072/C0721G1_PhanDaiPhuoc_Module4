package com.codegym.repository;

import com.codegym.model.ImageOfTheDay;

import java.util.List;

public interface IImageOfTheDayRepository {
    List<ImageOfTheDay> findAll();
    void saveOrUpdate (ImageOfTheDay imageOfTheDay);
    ImageOfTheDay like (Long id);
    ImageOfTheDay findById (Long id);
}
