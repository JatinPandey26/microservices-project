package com.JatinPandey.inventoryservice.DTO;

import lombok.Data;

import java.util.List;

@Data
public class OrderLineItemListDTO {
    List<OrderLineItem> orderLineItemList;
}
