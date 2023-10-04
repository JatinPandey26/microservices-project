package com.JatinPandey.orderSevice.DTO;

import com.JatinPandey.orderSevice.Entity.OrderLineItem;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private List<OrderLineItemsDTO> orderLineItemList;
}
