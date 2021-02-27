package com.commerce.inventory.repository;

import com.commerce.inventory.domain.Product;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
   // Product findProductBySku(String sku);
    Optional<Product> findByName(String name);
}
