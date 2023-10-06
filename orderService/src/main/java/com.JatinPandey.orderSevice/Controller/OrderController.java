package com.JatinPandey.orderSevice.Controller;

import com.JatinPandey.orderSevice.DTO.OrderLineItemResponse;
import com.JatinPandey.orderSevice.DTO.OrderLineItemsRequest;
import com.JatinPandey.orderSevice.DTO.OrderRequest;
import com.JatinPandey.orderSevice.DTO.OrderResponse;
import com.JatinPandey.orderSevice.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    @GetMapping("")
    ResponseEntity<List<OrderResponse>> getAllOrders(){
        List<OrderResponse> orderResponses = this.orderService.getAllOrders();
        return new ResponseEntity<>(orderResponses,HttpStatus.OK);
    }
    @PostMapping("/item")
    ResponseEntity<ApiResponse> createOrderLineItem(@RequestBody OrderLineItemsRequest orderLineItemsRequest){
        this.orderService.createOrderLineItem(orderLineItemsRequest);
        return new ResponseEntity<>(new ApiResponse("Order item created successfully",200),HttpStatus.CREATED);
    }

    @GetMapping("/item")
    ResponseEntity<List<OrderLineItemResponse>> getAllOrderLineItems(){
        List<OrderLineItemResponse> orderLineItemResponses = this.orderService.getAllOrderLineItems();
        return new ResponseEntity<List<OrderLineItemResponse>>(orderLineItemResponses,HttpStatus.OK);
    }

}
