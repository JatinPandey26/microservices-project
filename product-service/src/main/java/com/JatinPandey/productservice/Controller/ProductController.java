package com.JatinPandey.productservice.Controller;

import com.JatinPandey.productservice.ServiceImpl.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    ProductService productService;



}
