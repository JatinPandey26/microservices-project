package com.JatinPandey.productservice.ServiceInterface;

import com.JatinPandey.productservice.DTO.ProductRequest;
import com.JatinPandey.productservice.DTO.ProductResponse;

import java.util.List;

public interface ProductServiceInterface {
    void createProduct(ProductRequest productRequest);

    ProductResponse getProductById(long id);

    ProductResponse editProduct(ProductRequest productRequest);

    List<ProductResponse> getAllProducts();
}
