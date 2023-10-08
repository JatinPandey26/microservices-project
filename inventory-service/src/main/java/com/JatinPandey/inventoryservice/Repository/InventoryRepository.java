package com.JatinPandey.inventoryservice.Repository;

import com.JatinPandey.inventoryservice.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Inventory findByProductId(Long product_id);
}
