package com.graphql.service;

import com.graphql.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.client.HttpGraphQlClient;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryImpl implements InventoryService {

    @Autowired
    private HttpGraphQlClient httpGraphQlClient;

    @Override
    public List<Product> getAllProducts() {
        String getAllProductQuery = "query GetAllProduct {\n" +
                "    getAllProduct {\n" +
                "        name\n" +
                "        category\n" +
                "    }\n" +
                "}";
        return httpGraphQlClient.document(getAllProductQuery).retrieve("getAllProduct").toEntityList(Product.class).block();
    }

    @Override
    public List<Product> getAllProductByCategory(String category) {
        String getAllProductByCategory = String.format("query GetAllProduct {\n" +
                "    getProductByCategory(category: \"%s\") {\n" +
                "        id\n" +
                "        name\n" +
                "        category\n" +
                "    }\n" +
                "}", category);
        return httpGraphQlClient.document(getAllProductByCategory)
                .retrieve("getProductByCategory").toEntityList(Product.class).block();
    }
}

