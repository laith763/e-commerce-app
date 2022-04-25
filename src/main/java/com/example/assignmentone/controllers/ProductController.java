package com.example.assignmentone.controllers;


import com.example.assignmentone.constants.PathConstants;
import com.example.assignmentone.dto.ProductDto;
import com.example.assignmentone.exception.ApiRequestException;
import com.example.assignmentone.models.Product;
import com.example.assignmentone.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(PathConstants.Product.RESOURSE_BASE_V0)
public class ProductController {
    @Autowired
    ProductService productService;


    @GetMapping
    public List<ProductDto> getAllProduct() throws ApiRequestException{
        return productService.getAllProduct();
    }


    @GetMapping(PathConstants.ID)
    public ProductDto getProduct(@PathVariable Long id) throws ApiRequestException{
        return productService.getProduct(id);
    }

    @PostMapping
    public void addProduct(@RequestBody Product product) throws ApiRequestException{
        productService.addProduct(product);
    }

    @PutMapping
    public void updateProduct(@PathVariable Long id,@RequestBody Product product) throws ApiRequestException{
        productService.updateProduct(id,product);
    }

    @DeleteMapping
    public void deleteProduct(@PathVariable Long id) throws ApiRequestException{
        productService.deleteProduct(id);
    }
}
