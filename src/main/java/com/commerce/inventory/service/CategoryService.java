package com.commerce.inventory.service;

import com.commerce.inventory.domain.Category;
import com.commerce.inventory.repository.CategoryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private  final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category createCategory(String name, String shortDescription, String longDescription,
                                   Date activeStartDate, Date activeEndDate, String metaTitle, String metaDescription, String canonicalUrl) {
        logger.info("Loading category: " + name);
        return categoryRepository.findCategoryByName(name).orElse(
            categoryRepository.save(new Category(name, shortDescription, longDescription, activeStartDate, activeEndDate, metaTitle, metaDescription, canonicalUrl)
        ));
    }

    public CategoryRepository getCategoryRepository() {
        return categoryRepository;
    }
}
