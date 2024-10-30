package com.graphql.controller;

import com.graphql.dto.Product;
import com.graphql.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @GetMapping("/getAllProduct")
    public List<Product> getAllProducts() {
        return inventoryService.getAllProducts();
    }

    @GetMapping("/getAllProductByCategory/{category}")
    public List<Product> getAllProductByCategory(@PathVariable String category) {
        return inventoryService.getAllProductByCategory(category);
    }
}
