package com.JatinPandey.orderSevice.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table
@Data
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String OrderNumber = UUID.randomUUID().toString().toUpperCase();

    @ToString.Exclude
    @OneToMany(mappedBy = "orderEntity")
    private List<OrderLineItem> orderLineItemList = new ArrayList<>();
}
