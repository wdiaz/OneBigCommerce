package com.commerce.inventory.repository;

import com.commerce.inventory.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    Optional<Product> findProductBySku(String sku);

    Optional<Product> findByName(String name);

    @Override
    @RestResource(exported = false)
    <S extends Product> List<S> saveAll(Iterable<S> iterable);

    @Override
    @RestResource(exported = false)
    <S extends Product> S saveAndFlush(S s);

    @Override
    @RestResource(exported = false)
    void deleteInBatch(Iterable<Product> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAllInBatch();

    @Override
    @RestResource(exported = false)
    <S extends Product> S save(S s);

    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);

    @Override
    @RestResource(exported = false)
    void delete(Product product);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Product> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
