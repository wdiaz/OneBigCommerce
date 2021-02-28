package com.commerce.inventory.repository;

import com.commerce.inventory.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    Optional<Category> findCategoryByName(String name);

    Optional<Category> findCategoryById(Long id);

    @Override
    @RestResource(exported = false)
    <S extends Category> S saveAndFlush(S s);

    @Override
    @RestResource(exported = false)
    void deleteInBatch(Iterable<Category> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAllInBatch();

    @Override
    @RestResource(exported = false)
    <S extends Category> S save(S s);

    @Override
    @RestResource(exported = false)
    void deleteById(Long aLong);

    @Override
    @RestResource(exported = false)
    void delete(Category category);

    @Override
    @RestResource(exported = false)
    void deleteAll(Iterable<? extends Category> iterable);

    @Override
    @RestResource(exported = false)
    void deleteAll();
}
