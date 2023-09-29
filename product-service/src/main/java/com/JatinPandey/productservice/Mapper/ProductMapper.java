package com.JatinPandey.productservice.Mapper;

import com.JatinPandey.productservice.DTO.ProductRequest;
import com.JatinPandey.productservice.DTO.ProductResponse;
import com.JatinPandey.productservice.Entity.Product;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    Product toProduct(ProductRequest productRequest);

    ProductResponse toProductResponse(Product product);

    List<ProductResponse> toProductResponseList(List<Product> products);
}
