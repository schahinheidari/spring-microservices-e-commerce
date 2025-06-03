package com.example.inventory_service.repository;

import com.example.inventory_service.model.entity.Inventory;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InventoryDao extends CrudRepository<Inventory, Long> {
    Optional<Inventory> findBySkuCode(String skuCode);
}
