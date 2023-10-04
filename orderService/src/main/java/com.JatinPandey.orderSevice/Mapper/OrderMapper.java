package com.JatinPandey.orderSevice.Mapper;

import com.JatinPandey.orderSevice.DTO.OrderRequest;
import com.JatinPandey.orderSevice.Entity.OrderEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring",uses = {OrderLineItemMapper.class})
public interface OrderMapper {
    OrderEntity toOrder(OrderRequest orderRequest);

}
