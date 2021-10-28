package com.codegym.service.impl;

import com.codegym.model.ImageOfTheDay;
import com.codegym.repository.IImageOfTheDayRepository;
import com.codegym.service.IImageOfTheDayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageOfTheDayServiceImpl implements IImageOfTheDayService {
    @Autowired
    private IImageOfTheDayRepository iImageOfTheDayRepository;

    @Override
    public List<ImageOfTheDay> findAll() {
        return iImageOfTheDayRepository.findAll();
    }

    @Override
    public void saveOrUpdate(ImageOfTheDay imageOfTheDay) {
        iImageOfTheDayRepository.saveOrUpdate(imageOfTheDay);
    }

    @Override
    public ImageOfTheDay like(Long id) {
        return iImageOfTheDayRepository.like(id);
    }

    @Override
    public ImageOfTheDay findById(Long id) {
        return iImageOfTheDayRepository.findById(id);
    }
}
