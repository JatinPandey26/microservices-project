package com.JatinPandey.orderSevice.Service;

import com.JatinPandey.orderSevice.DTO.OrderLineItemResponse;
import com.JatinPandey.orderSevice.DTO.OrderLineItemsRequest;
import com.JatinPandey.orderSevice.DTO.OrderRequest;
import com.JatinPandey.orderSevice.DTO.OrderResponse;
import com.JatinPandey.orderSevice.Entity.OrderEntity;
import com.JatinPandey.orderSevice.Entity.OrderLineItem;
import com.JatinPandey.orderSevice.Mapper.OrderLineItemMapper;
import com.JatinPandey.orderSevice.Mapper.OrderMapper;
import com.JatinPandey.orderSevice.Repository.OrderLineItemRepository;
import com.JatinPandey.orderSevice.Repository.OrderRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
@Slf4j
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    OrderLineItemMapper orderLineItemMapper;

    @Autowired
    OrderLineItemRepository orderLineItemRepository;

    @Autowired
    RestTemplate restTemplate;

    public void placeOrder(OrderRequest orderRequest){
        OrderEntity orderEntity = orderMapper.toOrder(orderRequest);
        log.info(orderRequest.toString());
        log.info(orderEntity.toString());

        boolean isPlaceOrderSuccessInInventory = Boolean.TRUE.equals(restTemplate.postForObject("http://inventory-service/api/inventory/book", orderRequest, Boolean.class));
        if(!isPlaceOrderSuccessInInventory) return;
        orderRepository.save(orderEntity);
    }

    public List<OrderResponse> getAllOrders(){
        List<OrderEntity> orderEntities = this.orderRepository.findAll();
        log.info(orderEntities.toString());
        return this.orderMapper.toOrderResponseList(orderEntities);
    }

    public void createOrderLineItem(OrderLineItemsRequest orderLineItemsRequest){
        log.info(orderLineItemsRequest.toString());
        OrderLineItem orderLineItem = this.orderLineItemMapper.toOrderLineItem(orderLineItemsRequest);
        this.orderLineItemRepository.save(orderLineItem);
    }

    public List<OrderLineItemResponse> getAllOrderLineItems(){
        List<OrderLineItem> orderLineItemList = this.orderLineItemRepository.findAll();
        return this.orderLineItemMapper.toOrderLineItemResponseList(orderLineItemList) ;
    }

}
