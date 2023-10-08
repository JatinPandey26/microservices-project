package com.JatinPandey.inventoryservice.Services;

import com.JatinPandey.inventoryservice.DTO.InventoryRequest;
import com.JatinPandey.inventoryservice.DTO.InventoryResponse;
import com.JatinPandey.inventoryservice.DTO.OrderLineItem;
import com.JatinPandey.inventoryservice.Entity.Inventory;
import com.JatinPandey.inventoryservice.Mapper.InventoryMapper;
import com.JatinPandey.inventoryservice.Repository.InventoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service
public class InventoryService {

    @Autowired
    InventoryMapper mapper;

    @Autowired
    InventoryRepository inventoryRepository;
    public void addToInventory(InventoryRequest inventoryRequest){
        Inventory inventory = this.mapper.toInventory(inventoryRequest);
        System.out.println(inventory.toString());
        Inventory inventoryPresent = this.inventoryRepository.findByProductId(inventory.getProductId());
        if(inventoryPresent != null){
            inventoryPresent.setQuantity(inventory.getQuantity() + inventoryPresent.getQuantity());
            inventory = inventoryPresent;
        }
        this.inventoryRepository.save(inventory);
    }

    public List<InventoryResponse> getAllInventory(){
        List<Inventory> inventories = this.inventoryRepository.findAll();
        return this.mapper.toInventoryResponseList(inventories);
    }

    public Boolean checkProductInInventory(Long product_id , Long quantity){
        Inventory inventory = this.inventoryRepository.findByProductId(product_id);
        if(inventory == null) {
            throw new Error("product_id : " + product_id + " has no inventory stock");
        }
        boolean isEnoughStock = inventory.getQuantity() >= quantity;
        if(!isEnoughStock) throw new Error(inventory.toString() + " has not enough stocks");
        return true;
    }

    public void bookProductInInventory(Long product_id , Long quantity){
        Inventory inventory = this.inventoryRepository.findByProductId(product_id);
        inventory.setQuantity(inventory.getQuantity()-quantity);
        log.info(inventory.toString() + " -> " + quantity);
        this.inventoryRepository.save(inventory);
    }


    public Boolean checkAllItemsInOrderAndBook(List<OrderLineItem> orderLineItemList){
        boolean  isAllInStock = orderLineItemList.stream()
                .allMatch(order -> checkProductInInventory(order.getProduct_id(), order.getQuantity()));

        if(!isAllInStock) return false;

        orderLineItemList
                .forEach(order -> bookProductInInventory(order.getProduct_id(),order.getQuantity()));
        return true;
    }
}
