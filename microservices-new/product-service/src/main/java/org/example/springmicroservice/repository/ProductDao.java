package org.example.springmicroservice.repository;

import org.example.springmicroservice.model.entity.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDao extends MongoRepository<Product, String> {
}
