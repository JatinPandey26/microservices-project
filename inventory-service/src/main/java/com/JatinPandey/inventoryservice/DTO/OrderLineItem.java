package com.JatinPandey.inventoryservice.DTO;

import lombok.Data;

@Data
public class OrderLineItem {
    private Long id;
    private String skuCode;
    private Long product_id;
    private Long quantity;
}
