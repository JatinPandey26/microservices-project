package com.JatinPandey.orderSevice.Mapper;

import com.JatinPandey.orderSevice.DTO.OrderLineItemsDTO;
import com.JatinPandey.orderSevice.Entity.OrderEntity;
import com.JatinPandey.orderSevice.Entity.OrderLineItem;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OrderLineItemMapper {
    OrderLineItem toOrderLineItem(OrderLineItemsDTO orderLineItemsDTO);

    OrderLineItemsDTO toOrderLineItemsDTO(OrderLineItem orderLineItem);

    List<OrderEntity> toOrderList(List<OrderLineItem> orderLineItemList);
}
