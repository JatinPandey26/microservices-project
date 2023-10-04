package com.JatinPandey.orderSevice.DTO;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderLineItemsDTO {
    private long id;
    private String skuCode;
    private BigDecimal price;
    private Integer quantity;
}
