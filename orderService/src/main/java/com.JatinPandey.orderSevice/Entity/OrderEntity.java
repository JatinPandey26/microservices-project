package com.JatinPandey.orderSevice.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @GeneratedValue(strategy = GenerationType.UUID)
    private String OrderNumber;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "orderEntity")
    private List<OrderLineItem> orderLineItemList;
}
