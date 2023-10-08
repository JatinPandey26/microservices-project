package com.JatinPandey.inventoryservice.DTO;

import lombok.Data;

@Data
public class InventoryRequest {
    private Long productId;
    private Long quantity;
}
