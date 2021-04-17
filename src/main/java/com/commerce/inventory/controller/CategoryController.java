package com.commerce.inventory.controller;

import com.commerce.inventory.domain.Product;
import com.commerce.inventory.repository.CategoryRepository;
import com.commerce.inventory.repository.ProductRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(name = "category")
public class CategoryController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryController(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }
}
