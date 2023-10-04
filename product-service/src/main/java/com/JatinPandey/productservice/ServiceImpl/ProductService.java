package com.JatinPandey.productservice.ServiceImpl;

import com.JatinPandey.productservice.DTO.ProductRequest;
import com.JatinPandey.productservice.DTO.ProductResponse;
import com.JatinPandey.productservice.Entity.Product;
import com.JatinPandey.productservice.Mapper.ProductMapper;
import com.JatinPandey.productservice.Repository.ProductRepository;
import com.JatinPandey.productservice.ServiceInterface.ProductServiceInterface;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.integration.IntegrationProperties;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ProductService implements ProductServiceInterface {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void createProduct(ProductRequest productRequest) {
        Product product = this.productMapper.toProduct(productRequest);
        this.productRepository.save(product);
        log.info("Product created");
    }

    @Override
    public ProductResponse getProductById(long id) {
        Product product = this.productRepository.findById(id).orElseThrow(() -> new Error("product not found"));

        return this.productMapper.toProductResponse(product);
    }

    @Override
    public ProductResponse editProduct(ProductResponse productResponse) {
        Product product = this.productMapper.toProductFromProductResponse(productResponse);
        Product savedProduct = this.productRepository.save(product);
        return this.productMapper.toProductResponse(savedProduct);
    }

    @Override
    public List<ProductResponse> getAllProducts() {
        List<Product> products = this.productRepository.findAll();

        return this.productMapper.toProductResponseList(products);
    }

    @Override
    public void deleteProduct(long id) {
        this.productRepository.deleteById(id);
    }
}
