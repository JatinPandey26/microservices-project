package com.JatinPandey.orderSevice.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.UUID;

@Entity
@Table
@Data
public class OrderLineItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long product_id;

    @Column
    private String skuCode =  UUID.randomUUID().toString().toUpperCase();

    @Column
    private Integer quantity;


}
