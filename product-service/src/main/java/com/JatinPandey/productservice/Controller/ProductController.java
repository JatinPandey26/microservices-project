package com.JatinPandey.productservice.Controller;

import com.JatinPandey.productservice.ControllerAdvice.ApiResponse;
import com.JatinPandey.productservice.DTO.ProductRequest;
import com.JatinPandey.productservice.DTO.ProductResponse;
import com.JatinPandey.productservice.ServiceImpl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("")
    ResponseEntity<ApiResponse> createProduct(@RequestBody ProductRequest productRequest){
        this.productService.createProduct(productRequest);
        return new ResponseEntity<>(new ApiResponse("Product Created Successfully",200), HttpStatus.CREATED);
    }

    @PutMapping("")
    ResponseEntity<ProductResponse> editProduct(@RequestBody ProductResponse productResponse){
        ProductResponse editedProductResponse = this.productService.editProduct(productResponse);
        return new ResponseEntity<>(editedProductResponse,HttpStatus.OK);
    }

    @GetMapping("")
    ResponseEntity<ProductResponse> getById(@RequestParam Long id){
        ProductResponse productResponse = this.productService.getProductById(id);
        return new ResponseEntity<>(productResponse,HttpStatus.FOUND);
    }

    @GetMapping("/all")
    ResponseEntity<List<ProductResponse>> getAll(){
        List<ProductResponse> productResponseList = this.productService.getAllProducts();
        return new ResponseEntity<>(productResponseList,HttpStatus.FOUND);
    }

    @DeleteMapping("")
    ResponseEntity<ApiResponse> deleteProduct(@RequestParam Long id){
        this.productService.deleteProduct(id);
        return new ResponseEntity<>(new ApiResponse("Product deleted Successfully with id : " + id,200), HttpStatus.CREATED);
    }


}
