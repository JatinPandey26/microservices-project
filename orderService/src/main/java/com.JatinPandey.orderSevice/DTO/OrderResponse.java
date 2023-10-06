package com.JatinPandey.orderSevice.DTO;

import com.JatinPandey.orderSevice.Entity.OrderLineItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private long id;
    private String OrderNumber;
    private List<OrderLineItemResponse> orderLineItemList;
}
