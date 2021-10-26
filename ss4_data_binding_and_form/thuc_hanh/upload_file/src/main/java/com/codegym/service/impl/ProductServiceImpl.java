package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.service.IProductService;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceImpl implements IProductService {
    private List<Product> productList = new ArrayList<>();

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public void update(int id, Product product) {
        for (Product product1: productList) {
            if (product1.getId() == id) {
                product1 = product;
                break;
            }
        }
    }

    @Override
    public void remove(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                productList.remove(product);
                break;
            }
        }
    }
}
