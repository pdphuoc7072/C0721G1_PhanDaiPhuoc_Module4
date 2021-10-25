package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductRepositoryImpl implements IProductRepository {
    private static final Map<Integer, Product> products = new HashMap<>();

    static {
        products.put(1, new Product(1, "Iphone 12", 1213, "New", "Apple"));
        products.put(2, new Product(2, "Samsung S21 Ultra", 1320, "New", "Samsung"));
        products.put(3, new Product(3, "Google Pixel 5", 1150, "New", "Google"));
        products.put(4, new Product(4, "Oppo A71", 540, "New", "Oppo"));
        products.put(5, new Product(5, "Nokia 1130", 320, "New", "Nokia"));
        products.put(6, new Product(6, "Xiaomi Pocco", 645, "New", "Xiaomi"));
        products.put(7, new Product(7, "Samsung Galaxy S17", 890, "New", "Samsung"));
        products.put(8, new Product(8, "Iphone 13 Pro", 1450, "New", "Apple"));
        products.put(9, new Product(9, "Xiaomi AX50", 620, "New", "Xiaomi"));
        products.put(10, new Product(10, "Iphone 12 X", 1080, "New", "Apple"));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }

    @Override
    public List<Product> searchByName(String string) {
        List<Product> productListSearch = new ArrayList<>();
        List<Product> productList = findAll();
        for (Product product : productList) {
            if (product.getName().contains(string)) {
                productListSearch.add(product);
            }
        }
        return productListSearch;
    }
}
