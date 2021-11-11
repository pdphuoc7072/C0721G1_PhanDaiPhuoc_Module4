package com.codegym.service;

import com.codegym.model.Category;

public interface ICategoryService{
    Iterable<Category> findAll();
}
