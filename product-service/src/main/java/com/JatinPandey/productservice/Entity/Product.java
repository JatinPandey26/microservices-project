package com.JatinPandey.productservice.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.math.BigDecimal;

@Entity
@Table
@Data
public class Product {
    @Id
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private BigDecimal price;
}
