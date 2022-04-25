package com.example.assignmentone.services.servicesImpl;

import com.example.assignmentone.dto.ProductDto;
import com.example.assignmentone.exception.ApiRequestException;
import com.example.assignmentone.mappers.ProductMapper;
import com.example.assignmentone.models.Product;
import com.example.assignmentone.repositories.ProductRepositories;
import com.example.assignmentone.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    ProductRepositories productRepositories;

    @Autowired
    ProductMapper productMapper;
    @Override
    public List<ProductDto> getAllProduct() throws ApiRequestException {
        List <Product> productList = productRepositories.findAll();
        if(productList.size() == 0) throw new ApiRequestException("No Product in the system");
        return productMapper.convertListProductToDto(productList);
    }

    @Override
    public ProductDto getProduct(Long id) throws ApiRequestException {
        Product product = productRepositories.findById(id).orElseThrow(() -> new ApiRequestException(String.format("The product that has id %s not found",id)));
        return productMapper.convertProductToDto(product);
    }

    @Override
    public void addProduct(Product product) throws ApiRequestException {
        boolean isProductAlreadyExists = productRepositories.findById(product.getProductId()).isPresent();
        if(isProductAlreadyExists) throw new ApiRequestException("There is no two Product should have the same id");
        productRepositories.save(product);
    }




    @Override
    public void updateProduct(Long id, Product product) throws ApiRequestException {
        boolean isProductExists = productRepositories.findById(id).isPresent();
        if(!isProductExists) throw new ApiRequestException("The product you are trying to update does not exist");
        productRepositories.save(product);
    }

    @Override
    public void deleteProduct(Long id) throws ApiRequestException {
        boolean isProductExists = productRepositories.findById(id).isPresent();
        if(!isProductExists) throw new ApiRequestException("The product you are trying to delete does not exist");
        productRepositories.deleteById(id);
    }
}
