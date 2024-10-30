package com.graphql.service;

import com.graphql.dto.Product;

import java.util.List;

public interface InventoryService {
    List<Product> getAllProducts();

    List<Product> getAllProductByCategory(String category);

}
