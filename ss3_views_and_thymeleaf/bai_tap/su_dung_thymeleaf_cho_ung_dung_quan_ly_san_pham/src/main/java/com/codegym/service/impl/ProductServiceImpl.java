package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.impl.ProductRepositoryImpl;
import com.codegym.service.IProductService;

import java.util.List;

public class ProductServiceImpl implements IProductService {
    ProductRepositoryImpl productRepository = new ProductRepositoryImpl();

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return productRepository.findById(id);
    }

    @Override
    public void update(int id, Product product) {
        productRepository.update(id, product);
    }

    @Override
    public void remove(int id) {
        productRepository.remove(id);
    }

    @Override
    public List<Product> searchByName(String string) {
        return productRepository.searchByName(string);
    }
}
