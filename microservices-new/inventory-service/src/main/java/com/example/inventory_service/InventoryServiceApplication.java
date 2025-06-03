package com.example.inventory_service;

import com.example.inventory_service.model.entity.Inventory;
import com.example.inventory_service.repository.InventoryDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	public CommandLineRunner loadData(InventoryDao inventoryDao) {
		return args -> {
			Inventory inventory = new Inventory();
			inventory.setSkuCode("iphone_13");
			inventory.setQuantity(10);

			Inventory inventory1 = new Inventory();
			inventory1.setSkuCode("iphone_13_black");
			inventory1.setQuantity(100);

			inventoryDao.save(inventory);
			inventoryDao.save(inventory1);
		};
	}

}
