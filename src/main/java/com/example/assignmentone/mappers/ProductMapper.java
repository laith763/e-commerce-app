package com.example.assignmentone.mappers;

import com.example.assignmentone.dto.ProductDto;
import com.example.assignmentone.models.Product;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class ProductMapper {

    @Autowired
    private ModelMapper modelMapper;

    public ProductDto convertProductToDto(Product product){
        ProductDto productDto;
        productDto = modelMapper.map(product, ProductDto.class);
        return productDto;
    }
    public List<ProductDto> convertListProductToDto(List<Product> products){
        return products.stream().map(x -> convertProductToDto(x)).collect(Collectors.toList());
    }
    public Product convertDtoToProduct(ProductDto productDto){
        Product product;
        product = modelMapper.map(productDto, Product.class);
        return product;
    }
    public List<Product> convertListDtoToProduct(List<ProductDto> dto)
    {
        return dto.stream().map(x -> convertDtoToProduct(x)).collect(Collectors.toList());
    }
}
