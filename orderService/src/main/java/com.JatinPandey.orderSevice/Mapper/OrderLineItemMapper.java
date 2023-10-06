package com.JatinPandey.orderSevice.Mapper;

import com.JatinPandey.orderSevice.DTO.OrderLineItemResponse;
import com.JatinPandey.orderSevice.DTO.OrderLineItemsRequest;
import com.JatinPandey.orderSevice.Entity.OrderEntity;
import com.JatinPandey.orderSevice.Entity.OrderLineItem;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedSourcePolicy = ReportingPolicy.IGNORE,unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface OrderLineItemMapper {
    OrderLineItem toOrderLineItem(OrderLineItemsRequest orderLineItemsDTO);

    OrderLineItem toOrderLineItemFromOrderLineResponse(OrderLineItemResponse orderLineItemsDTO);

    OrderLineItemsRequest toOrderLineItemsDTO(OrderLineItem orderLineItem);

    OrderLineItemResponse toOrderLineItemResponse(OrderLineItem orderLineItem);
    List<OrderLineItem> toOrderLineList(List<OrderLineItemsRequest> orderLineItemList);

    List<OrderLineItemResponse> toOrderLineItemResponseList(List<OrderLineItem> orderLineItemList);
}
