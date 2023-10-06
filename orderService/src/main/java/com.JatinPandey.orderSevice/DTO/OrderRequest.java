package com.JatinPandey.orderSevice.DTO;

import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private List<OrderLineItemsRequest> orderLineItemList;
}
