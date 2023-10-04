package com.JatinPandey.orderSevice.Controller;

import com.JatinPandey.orderSevice.DTO.OrderRequest;
import com.JatinPandey.orderSevice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/order")
public class OrderController {

    @Autowired
    OrderService orderService;

    @PostMapping("")
    ResponseEntity<ApiResponse> createProduct(@RequestBody OrderRequest orderRequest){
        this.orderService.placeOrder(orderRequest);
        return new ResponseEntity<>(new ApiResponse("OrderEntity Created Successfully",200), HttpStatus.CREATED);
    }

}
