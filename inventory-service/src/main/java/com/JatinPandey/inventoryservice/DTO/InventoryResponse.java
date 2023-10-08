package com.JatinPandey.inventoryservice.DTO;

import lombok.Data;

@Data
public class InventoryResponse {
    private Long id;
    private Long productId;
    private Long quantity;
}
