package com.JatinPandey.inventoryservice.Controller;

import com.JatinPandey.inventoryservice.ControllerAdvice.ApiResponse;
import com.JatinPandey.inventoryservice.DTO.InventoryRequest;
import com.JatinPandey.inventoryservice.DTO.InventoryResponse;
import com.JatinPandey.inventoryservice.DTO.OrderLineItem;
import com.JatinPandey.inventoryservice.DTO.OrderLineItemListDTO;
import com.JatinPandey.inventoryservice.Services.InventoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {
    @Autowired
    InventoryService inventoryService;

    @PostMapping("")
    public ResponseEntity<ApiResponse> addToInventory(@RequestBody InventoryRequest inventoryRequest){
        log.info(inventoryRequest.toString());
        this.inventoryService.addToInventory(inventoryRequest);
        return new ResponseEntity<>(new ApiResponse("Inventory updated",200), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<List<InventoryResponse>> getAllInventory(){
        List<InventoryResponse> inventoryResponses = this.inventoryService.getAllInventory();
        return new ResponseEntity<>(inventoryResponses,HttpStatus.OK);
    }

    @PostMapping("/book")
    public  ResponseEntity<Boolean> checkAndBookTheProducts(@RequestBody OrderLineItemListDTO OrderLineItemListDTO){
        return new ResponseEntity<>(this.inventoryService.checkAllItemsInOrderAndBook(OrderLineItemListDTO.getOrderLineItemList()),HttpStatus.OK);
    }
}
