package com.JatinPandey.orderSevice.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderLineItemResponse {
    private Long id;
    private String skuCode;
    private Long product_id;
    private Integer quantity;
}
