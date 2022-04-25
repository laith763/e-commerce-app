package com.example.assignmentone.services;


import com.example.assignmentone.dto.ProductDto;
import com.example.assignmentone.exception.ApiRequestException;
import com.example.assignmentone.models.Product;

import java.util.List;

public interface ProductService {
    List<ProductDto> getAllProduct() throws ApiRequestException;

    ProductDto getProduct(Long id) throws ApiRequestException;

    void addProduct(Product product) throws ApiRequestException;

    void updateProduct(Long id, Product product) throws ApiRequestException;

    void deleteProduct(Long id) throws ApiRequestException;
}
