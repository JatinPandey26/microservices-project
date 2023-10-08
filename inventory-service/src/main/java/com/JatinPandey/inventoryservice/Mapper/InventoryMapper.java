package com.JatinPandey.inventoryservice.Mapper;

import com.JatinPandey.inventoryservice.DTO.InventoryRequest;
import com.JatinPandey.inventoryservice.DTO.InventoryResponse;
import com.JatinPandey.inventoryservice.Entity.Inventory;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",unmappedTargetPolicy = ReportingPolicy.IGNORE,unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface InventoryMapper {
    Inventory toInventory(InventoryRequest inventoryRequest);
    InventoryResponse toInventoryResponse(Inventory inventory);

    List<InventoryResponse> toInventoryResponseList(List<Inventory> inventories);
}
