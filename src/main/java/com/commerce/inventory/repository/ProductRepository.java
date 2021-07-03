package com.commerce.inventory.repository;

import com.commerce.inventory.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    Product findProductBySku(String sku);
    Product findProductByName(String name);
}
