package com.commerce.inventory.repository;

import com.commerce.inventory.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductBySku(String sku);

    Optional<Product> findByName(String name);
}
