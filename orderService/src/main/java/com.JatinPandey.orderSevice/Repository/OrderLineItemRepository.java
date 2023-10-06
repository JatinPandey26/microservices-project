package com.JatinPandey.orderSevice.Repository;

import com.JatinPandey.orderSevice.Entity.OrderLineItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineItemRepository extends JpaRepository<OrderLineItem,Long> {
}
