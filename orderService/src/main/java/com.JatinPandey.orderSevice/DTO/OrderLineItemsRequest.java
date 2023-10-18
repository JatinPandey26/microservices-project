package com.JatinPandey.orderSevice.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderLineItemsRequest {

    private Long product_id;
    private Integer quantity;
}
