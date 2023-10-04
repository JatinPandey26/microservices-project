package com.JatinPandey.orderSevice.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table
@Data
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String skuCode;
    @Column
    private BigDecimal price;
    @Column
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name="order_entity_id", nullable=false)
    private OrderEntity orderEntity;
}
