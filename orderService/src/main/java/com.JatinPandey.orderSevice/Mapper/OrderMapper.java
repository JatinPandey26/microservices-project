package com.JatinPandey.orderSevice.Mapper;

import com.JatinPandey.orderSevice.DTO.OrderRequest;
import com.JatinPandey.orderSevice.DTO.OrderResponse;
import com.JatinPandey.orderSevice.Entity.OrderEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring",uses = {OrderLineItemMapper.class})
public interface OrderMapper {
    OrderEntity toOrder(OrderRequest orderRequest);
    OrderEntity toOrderFromOrderResponse(OrderResponse orderResponse);
    OrderResponse toOrderResponse(OrderEntity orderEntity);

    List<OrderResponse> toOrderResponseList(List<OrderEntity> orderEntities);

    List<OrderEntity> toOrderEntity(List<OrderRequest> orderRequests);
}
