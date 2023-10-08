package com.JatinPandey.inventoryservice.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table
@Data
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private Long productId;

    @Column
    private Long quantity;

}
