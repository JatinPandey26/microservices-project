package com.JatinPandey.orderSevice.Service;

import com.JatinPandey.orderSevice.DTO.OrderRequest;
import com.JatinPandey.orderSevice.Entity.OrderEntity;
import com.JatinPandey.orderSevice.Mapper.OrderMapper;
import com.JatinPandey.orderSevice.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    OrderRepository orderRepository;

    public void placeOrder(OrderRequest orderRequest){
        OrderEntity orderEntity = orderMapper.toOrder(orderRequest);

        orderRepository.save(orderEntity);
    }

}
