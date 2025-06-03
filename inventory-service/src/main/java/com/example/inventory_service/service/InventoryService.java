package com.example.inventory_service.service;

import com.example.inventory_service.repository.InventoryDao;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InventoryService {
    private final InventoryDao inventoryDao;

    @Transactional(readOnly = true)
    public boolean isInStock(String skuCode){
        return inventoryDao.findBySkuCode(skuCode).isPresent();
    }
}
